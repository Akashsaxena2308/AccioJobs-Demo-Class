# Java Multithreading Assignment

Complete all three problems in plain Java. Use separate demo classes so each problem can be run independently. A thread that starts first can finish second, so check the number of successes and the final state regardless of which thread wins.

## 1. Seat booking

Two customers try to reserve the last seat at the same time. Build a shared inventory that never books more seats than it has available.

- Create `SeatInventory` with a constructor that takes the initial seat count. Reject a negative count with `IllegalArgumentException`.
- Implement `boolean bookOneSeat()`. Reserve one seat and return `true` if a seat is available. Return `false` and leave the count unchanged if the inventory is empty.
- Implement `int getRemainingSeats()`.
- Create `BookingDemo`. Start two threads that each try to book one seat from the **same** inventory. Wait for both to finish, then print both results and the remaining count.

Try a fresh inventory with each of these starting counts.

| Starting seats | Successful bookings | Failed bookings | Remaining seats |
|---:|---:|---:|---:|
| 0 | 0 | 2 | 0 |
| 1 | 1 | 1 | 0 |
| 2 | 2 | 0 | 0 |

## 2. Shared wallet

Two people share a wallet with a balance of 1,000. Each tries to withdraw 700 on a separate thread. The wallet must never go below zero.

- Create `Wallet` with a constructor that takes the initial balance. Reject a negative balance with `IllegalArgumentException`.
- Implement `boolean withdraw(int amount)`. Deduct the amount and return `true` if the balance covers it. Return `false` if funds are insufficient. Throw `IllegalArgumentException` for zero or negative amounts. Rejected withdrawals leave the balance unchanged.
- Implement `int getBalance()`.
- Create `WalletDemo`. Start both threads on the **same** wallet, wait for both to finish, and print their results and the final balance. Expect one success, one failure, and a balance of 300.

On fresh wallets with a balance of 300, try withdrawing 300, 400, and 0. Check both the result and the balance in each case.

## 3. Concurrent clinic booking

The clinic has two appointment slots. `MORNING` has two places and `AFTERNOON` has one. Each request reserves one place for one patient. Never exceed a slot’s capacity or book the same patient twice in the same slot. A patient may reserve a place in both slots.

### Build and run

Create these Java types.

| Type | Responsibility |
|---|---|
| `BookingRequest` | Immutable request with string fields `slotId` and `patientId`, a constructor, and getters. |
| `BookingResult` | Enum with `BOOKED`, `ALREADY_BOOKED`, `FULL`, `SLOT_NOT_FOUND`, and `INVALID_REQUEST`. |
| `AppointmentSlot` | Holds the slot ID, a positive capacity, and the IDs of patients already booked. Provide `book(String patientId)` and `getRemainingSeats()`. |
| `ClinicBookingService` | Stores one shared slot object per ID. Its `book(BookingRequest request)` validates the request, finds the slot, and delegates the booking. |
| `ClinicBookingDemo` | Creates the slots and service, submits the sample requests to a pool of two threads, and prints the results. |

Apply the rules in this order.

1. Return `INVALID_REQUEST` for a null request or a null or blank slot ID or patient ID.
2. Return `SLOT_NOT_FOUND` for an unknown slot ID.
3. Return `ALREADY_BOOKED` if the patient already has a place in that slot. This rule takes priority even when the slot is full.
4. Return `FULL` if there is no space left.
5. Otherwise, reserve a place and return `BOOKED`.

Use a fixed thread pool with two workers. Submit each request as a `Callable<BookingResult>`. Submit **all** requests before calling `Future.get()` to collect the results. Keep each result paired with its original request and close the pool when finished.

Start with fresh slots. Submit `P101`, `P102`, and `P103` to `MORNING`, and `P201` and `P202` to `AFTERNOON`. Print each request and its result, followed by the totals and the remaining places in each slot. Expect **3 `BOOKED`**, **2 `FULL`**, and **0 places remaining in each slot**.

## Submission

Submit the Java source and sample output for all three problems. For each one, identify the shared object and the operations that need to happen together.
