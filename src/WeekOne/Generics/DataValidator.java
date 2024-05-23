package WeekOne.Generics;

public class DataValidator {
    public static class PositiveNumberValidator implements Validator<Number> {
        @Override
        public boolean validate(Number value) {
            return value.doubleValue() > 0;
        }
    }
    public static class NonEmptyStringValidator implements Validator<String> {
        @Override
        public boolean validate(String value) {
            return value != null && !value.isEmpty();
        }
    }

    public static interface Validator<T> {
        boolean validate(T value);
    }

    public static void main (String[] args){
        NonEmptyStringValidator stringValidator = new NonEmptyStringValidator();
        PositiveNumberValidator numberValidator = new PositiveNumberValidator();

        boolean stringValid = stringValidator.validate("string");
        boolean numberValid = numberValidator.validate(50);

        if(stringValid) System.out.println("String valid");
        if(numberValid) System.out.println("Number valid");
    }


}
