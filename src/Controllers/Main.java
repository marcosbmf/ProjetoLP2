package Controllers;

import easyaccept.EasyAccept;

public class Main {

	public static void main(String[] args) {
		args = new String[] { "Controllers.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt" };

		EasyAccept.main(args);

	}

}
