import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a password: ");
            String password = scanner.nextLine();

            PasswordStrengthResult result = checkPasswordStrength(password);

            if (result.isStrong) {
                System.out.println("Password Strength: Strong");
                break;
            } else {
                System.out.println("Password is not strong. Hints:");
                if (!result.hasUppercase) {
                    System.out.println(" - Add at least one uppercase letter");
                }
                if (!result.hasLowercase) {
                    System.out.println(" - Add at least one lowercase letter");
                }
                if (!result.hasSpecialChar) {
                    System.out.println(" - Add at least one special character (!@#$%^&*)");
                }
            }
        }

        scanner.close();
    }

    public static class PasswordStrengthResult {
        boolean isStrong;
        boolean hasUppercase;
        boolean hasLowercase;
        boolean hasSpecialChar;

        public PasswordStrengthResult(boolean isStrong, boolean hasUppercase, boolean hasLowercase, boolean hasSpecialChar) {
            this.isStrong = isStrong;
            this.hasUppercase = hasUppercase;
            this.hasLowercase = hasLowercase;
            this.hasSpecialChar = hasSpecialChar;
        }
    }

    public static PasswordStrengthResult checkPasswordStrength(String password) {
        boolean hasUppercase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasLowercase = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasSpecialChar = Pattern.compile("[!@#$%^&*]").matcher(password).find();

        boolean isStrong = hasUppercase && hasLowercase && hasSpecialChar;

        return new PasswordStrengthResult(isStrong, hasUppercase, hasLowercase, hasSpecialChar);
    }
}
