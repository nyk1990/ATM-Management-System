package main;

import helper.AccountHelper;
import java.util.InputMismatchException;
import java.util.Scanner;
import static constant.AccountEnum.ACCOUNT_1;
import static constant.AccountEnum.ACCOUNT_2;

/**
 * This is the main class for Account System.
 */
public class AccountMain {

	public static void main(String[] args) {
		AccountMain program = new AccountMain();
		program.displayMainOptions();
	}

	public void displayMainOptions() {
		// Call the helper service to start the account component.
		AccountHelper accountDelegate = AccountHelper.getInstance();

		boolean flag = true;
		while (flag) {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			int option = -1;
			System.out.println("Welcome to Account System");
			System.out.println("1. Account - 1");
			System.out.println("2. Account - 2");
			System.out.println("3. Exit");
			System.out.println();

			System.out.println("Select option (1-3): ");
			try {
				option = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input");
				continue;
			}
			switch (option) {
			case 1:
				accountDelegate.service(ACCOUNT_1);
				break;
			case 2:
				accountDelegate.service(ACCOUNT_2);
				break;
			case 3:
				System.out.println("Exiting the System, Thank You !!");
				flag = false;
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
		}

	}
}
