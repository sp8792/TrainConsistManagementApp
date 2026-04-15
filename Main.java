package app;

public class TrainConsistApp {

    // ---- CUSTOM RUNTIME EXCEPTION
    public static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie model
    public static class GoodsBogie {
        private final String shape;
        private String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public String getShape() { return shape; }
        public String getCargo() { return cargo; }

        // Assign cargo with safety validation
        public void assignCargo(String cargo) {
            try {
                // Rule: Rectangular cannot carry Petroleum
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("UC15 - Safe Cargo Assignment Using try-catch-finally\n");

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum");   // valid

        System.out.println();

        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum");   // invalid

        System.out.println("\nUC15 runtime handling completed ...");
    }
}
