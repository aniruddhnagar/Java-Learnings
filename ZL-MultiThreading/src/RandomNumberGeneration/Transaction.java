package RandomNumberGeneration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class Transaction {

    private static AtomicLong transactionCounter = null;

    //Unique IDs
    Transaction() {
        transactionCounter = new AtomicLong(0);
    }

    public void generateTransactionId1() {
        // Generate a unique transaction ID
        long transactionNumber = transactionCounter.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println("TXN" + timestamp + String.format("%010d", transactionNumber));
    }

    public void generateTransactionId2() {
        System.out.println("TXN" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
    }
}
