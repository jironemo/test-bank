# Bank Sandbox (MVP v0.1) — Spec

## Goal
Provide a sandbox payment ecosystem (Stripe-like, but QR wallet style) so student merchants can:
- register a merchant account
- get API credentials
- create payment requests
- generate QR codes / links for those requests
- receive a webhook callback when a payment succeeds or fails

A consumer "wallet" app (or simple web checkout) can scan QR / open links and simulate payment confirmation.

---

## Roles
### Merchant (developer)
- owns a merchant account
- authenticates to merchant portal (username/password)
- authenticates to API using a secret key

### Consumer (payer)
- uses wallet app / web checkout to pay a payment request

### Bank Admin (optional for MVP)
- can seed test users and view all transactions

---

## Merchant Portal (MVP)
### Authentication
- Username + password (basic login) for portal access
- Portal session can be JWT or server session cookie (implementation choice)

### Merchant onboarding
- `POST /merchant/signup` (org name, username, password)
- (MVP: auto-approve)

### API key management
- Merchant can generate a secret API key for server-to-server calls:
  - `POST /merchant/api-keys`
  - returns: `sk_test_xxx` (shown only once)
- Backend stores only a hash of the secret key.

---

## Merchant API (MVP)
All requests must include:
- `Authorization: Bearer <sk_test_xxx>`

### Create a payment request (dynamic QR)
- `POST /v1/payment-requests`
  - body: amount, currency, description, callback_url, expires_in (optional)
  - returns:
    - payment_request_id
    - status=CREATED
    - checkout_url
    - qr_payload (string encoded into a QR)

### Get payment request status
- `GET /v1/payment-requests/{id}`

### List transactions
- `GET /v1/transactions?from=&to=`

---

## QR / Link Formats
### Checkout URL (recommended for MVP)
QR encodes a URL like:
- `https://sandbox-pay.local/checkout/{payment_request_id}`

### Optional deep link (later)
- `sandboxpay://checkout/{payment_request_id}`

---

## Consumer Checkout (MVP)
### Start checkout
- Wallet app scans QR or opens checkout_url
- App loads payment request details:
  - `GET /v1/payment-requests/{id}` (public endpoint, read-only)

### Confirm payment
- `POST /v1/payment-requests/{id}/confirm`
  - body: payer_id (optional for MVP), confirm=true
  - results in a transaction and status update

---

## Payment State Machine
`CREATED -> PENDING -> SUCCEEDED | FAILED | EXPIRED`

Rules:
- Only one terminal state
- Confirming an already terminal request returns the existing final state (idempotent)

---

## Webhooks (MVP)
When payment transitions to SUCCEEDED or FAILED:
- send a POST request to merchant's callback_url

Payload:
{
  "event_id": "evt_...",
  "type": "payment.succeeded",
  "created_at": "...",
  "data": {
    "payment_request_id": "...",
    "amount": 1000,
    "currency": "MMK",
    "status": "SUCCEEDED"
  }
}

Delivery:
- at-least-once (merchant must handle duplicates)
- retry policy: e.g., 1m, 5m, 15m, 1h (MVP can start with 3 retries)

Security:
- webhook signature header: `X-Sandbox-Signature: <hmac>`
- merchant verifies signature using its webhook secret (generated in portal)

---

## MVP Non-goals
- real balance checks / wallet ledger
- refunds / disputes
- KYC/AML simulation
- settlement batching
- multi-currency conversion
