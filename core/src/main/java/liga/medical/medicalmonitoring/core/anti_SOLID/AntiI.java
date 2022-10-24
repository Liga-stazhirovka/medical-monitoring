package liga.medical.medicalmonitoring.core.anti_SOLID;

public class AntiI {
    public interface Employee {
        int getSalaryWorker();

        int getSalaryManager();

        int getSalaryEngineer();
    }

    class SalaryServiceWorker implements Employee {

        @Override
        public int getSalaryWorker() {
            return 1000;
        }

        @Override
        public int getSalaryManager() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getSalaryEngineer() {
            throw new UnsupportedOperationException();
        }
    }

    class SalaryServiceManager implements Employee {

        @Override
        public int getSalaryWorker() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getSalaryManager() {
            return 1000;
        }

        @Override
        public int getSalaryEngineer() {
            throw new UnsupportedOperationException();
        }
    }

    class SalaryServiceEngineer implements Employee {

        @Override
        public int getSalaryWorker() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getSalaryManager() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getSalaryEngineer() {
            return 1000;
        }
    }
}
