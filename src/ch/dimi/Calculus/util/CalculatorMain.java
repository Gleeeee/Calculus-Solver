//�ڱԳ�
package ch.dimi.Calculus.util;

public class CalculatorMain {

	String processedFunction = "";
	String[] dividedFunctions = new String[1000];
	String[] dividedFunctionsProcessed = new String[1000];
	char[] dividedOperators = new char[1000];
	int from;
	int until;
	int cnt;

	public void integral(String func) {

		/*
		 * Divider �� �̿��� �Է¹��� �Լ��� ���׽����� �ɰ� �� �� ���׽��� dividedFunctions �� �����ϰ�, ��
		 * �����ڸ� dividedOperators �� �����Ѵ�.
		 */
		Divider divider = new Divider();
		divider.setBase(func);
		dividedFunctions = divider.expo;
		dividedOperators = divider.Operator;
		cnt = divider.cnt;

		/*
		 * ������ ����� dividedFunctions �� �Լ� �������� ���� ������ dividedFunctionsProcessed ��
		 * �����Ѵ�.
		 */
		dividedFunctionsProcessed = new String[100];

		for (int i = 0; i < cnt; i++) {
			System.out.println("integral - ���� ó�� ���� ���׽� : " + dividedFunctions[i]);
			switch (getFunctionType(dividedFunctions[i])) {

			case "triangle":
				// dividedFunctionsProcessed[i] = calcTriangle(func, from,
				// until);
				break;

			case "exponential":
				// dividedFunctionsProcessed[i] = calcExponential(func, from,
				// until);
				break;

			case "polynomial":
				// dividedFunctionsProcessed[i] = calcPolynomial(func, from,
				// until);
				break;

			default:
				// dividedFunctionsProcessed[i] = "error";
				break;

			}

		}

		/*
		 * ������ ���е� ����� String ���·� ��� ���� ���� ���� ������� processedFunction �� �����Ѵ�.
		 */
		for (int i = 0; i < cnt; i++) {
			System.out.println("integral - ���� ó�� ���� ���׽� : " + dividedFunctionsProcessed[i]);
			processedFunction += dividedFunctionsProcessed[i];
			try {
				processedFunction += dividedOperators[i];
			} catch (ArrayIndexOutOfBoundsException e) {
				// �����ڴ� ���׽��� �������� 1�� �����Ƿ� Exception ó��
			}
		}
	}

	public void differential(String func) {

		/*
		 * Divider �� �̿��� �Է¹��� �Լ��� ���׽����� �ɰ� �� �� ���׽��� dividedFunctions �� �����ϰ�, ��
		 * �����ڸ� dividedOperators �� �����Ѵ�.
		 */
		System.out.println("differential - �޼ҵ� �����");
		
		Divider divider = new Divider();
		divider.setBase(func);
		dividedFunctions = divider.expo.clone();
		dividedOperators = divider.Operator.clone();
		cnt = divider.cnt;
		
		System.out.print("differential - ������ ���׽� ���ʴ�� ��� : ");
		for (int i = 0; i <= cnt; i++) {
			System.out.print("'" + dividedFunctions[i] + "' ");
		}		
		System.out.println();
		
		/*
		 * ������ ����� dividedFunctions �� �Լ� �������� ���� �̺��� dividedFunctionsProcessed ��
		 * �����Ѵ�.
		 */
		for (int i = 0; i <= cnt; i++) {

			System.out.println("differential - �̺� ����ϴ� ���׽� : " + dividedFunctions[i]);

			switch (getFunctionType(dividedFunctions[i])) {

			case "triangle":
				// dividedFunctionsProcessed[i] = calcTriangle(func, from,
				// until);
				break;

			case "exponential":
				Exponential_function calculus = new Exponential_function();
				dividedFunctionsProcessed[i] = calculus.calcExponential(dividedFunctions[i]);
				break;

			case "polynomial":
				// dividedFunctionsProcessed[i] = calcPolynomial(func, from,
				// until);
				break;

			default:
				// dividedFunctionsProcessed[i] = "error";
				break;

			}

		}

		/*
		 * ������ �̺е� ����� String ���·� ��� ���� ���� �̺� ������� processedFunction �� �����Ѵ�.
		 */
		System.out.print("differential - �̺е� ���׽� ���ʴ�� ��� : ");
		for (int i = 0; i <= cnt; i++) {
			System.out.print("'" + dividedFunctionsProcessed[i] + "' ");
			processedFunction += dividedFunctionsProcessed[i];
			try {
				processedFunction += dividedOperators[i];
			} catch (ArrayIndexOutOfBoundsException e) {
				// �����ڴ� ���׽��� �������� 1�� �����Ƿ� Exception ó��
			}
		}
		System.out.println();
	}

	public String getProcessedFunction() {
		System.out.println("getProcessedFunction - processedFunction ��ȯ��");
		return processedFunction;
	}

	public double getSpecificValue(double value) {

		double result = 0;

		for (int i = 0; i <= cnt; i++) {
			System.out.println("getSpecificValue - ���԰��� ��� ���� ����ϴ� ���׽� : " + dividedFunctions[i]);

			switch (getFunctionType(dividedFunctions[i])) {

			case "triangle":
				System.out.println("�ش� ���׽��� ���� �� ���� ���� �� ��");
				// result += getExponentialSpecificValue(dividedFunctions[i],
				// value);
				break;

			case "exponential":
				result += getExponentialSpecificValue(dividedFunctions[i], value);
				break;

			case "polynomial":
				System.out.println("�ش� ���׽��� ���� �� ���� ���� �� ��");
				// result += getExponentialSpecificValue(dividedFunctions[i],
				// value);
				break;

			default:
				System.out.println("���׽��� ������ �� �� ����");
				// dividedFunctionsProcessed[i] = "error";
				break;

			}

		}

		return result;
	}
	
	public double getDifferentialedValue(int value) {
		double result = 0;

		for (int i = 0; i <= cnt; i++) {
			System.out.println("getDifferentialValue - ���԰��� ��� ���� ����ϴ� ���׽� : " + dividedFunctionsProcessed[i]);

			switch (getFunctionType(dividedFunctionsProcessed[i])) {

			case "triangle":
				System.out.println("�ش� ���׽��� ���� �� ���� ���� �� ��");
				// result += getExponentialSpecificValue(dividedFunctionsProcessed[i],
				// value);
				break;

			case "exponential":
				result += getExponentialSpecificValue(dividedFunctionsProcessed[i], value);
				break;

			case "polynomial":
				System.out.println("�ش� ���׽��� ���� �� ���� ���� �� ��");
				// result += getExponentialSpecificValue(dividedFunctionsProcessed[i],
				// value);
				break;

			default:
				System.out.println("���׽��� ������ �� �� ����");
				// dividedFunctionsProcessed[i] = "error";
				break;

			}

		}

		return result;
	}
	
	public double getIntegraledValue(int from, int until) {
		double result = 0;
		result = getSpecificValue(until) - getSpecificValue(from);
		return result;
	}

	public String getFunctionType(String func) {
		if (func.contains("sin") || func.contains("cos"))
			return "triangle";
		else if (func.contains("^"))
			return "exponential";
		else
			return "polynomial";
	}
	
	public double getPolynomialSpecificValue(String func, double value) {
		//2x^5 ���·� �Լ��� �޴´�.
		double multiply = 1;
		double result = 0;
		
		int xIndex = func.indexOf('x');
		String multiplyCandidate = func.substring(0, xIndex);
		multiply = Integer.parseInt(multiplyCandidate);
		
		func = func.substring(xIndex); //�Լ����� ����� ������
		int powSymbolIndex = func.indexOf('^');
		String powNumCandidate = func.substring(powSymbolIndex+1);
		double powNum = Integer.parseInt(powNumCandidate);
		
		result = multiply * Math.pow(value, powNum);
		return result;
	}
	
	public double getExponentialSpecificValue(String func, double value) {
		//ln2*2^x ���·� �Լ��� �޴´�.
		//TODO 3*ln2*2^x�� ���.
		double multiply = 1;
		double result = 0;
		int multiplySymbolIndex = func.indexOf('*');
		
		// ����� ���� ��� multiply�� ���� ����� �����ϰ�, �Լ����� ����� ������
		if (multiplySymbolIndex != -1) {
			String multiplyCandidate = func.substring( 0, multiplySymbolIndex );
			System.out.println("getExponentialSpecificValue - multiplyCandidate�� �� : " + multiplyCandidate);
			if (multiplyCandidate.contains("ln")) {
				String lnRemoved = multiplyCandidate.substring(2); //���� ��� ln3 �� ���, ln�� ������ ���� �κи� �߸�
				int parsed = Integer.parseInt(lnRemoved);
				multiply = Math.log(parsed);
				func = func.substring(multiplySymbolIndex + 1);
			} else {
				multiply = (double) Integer.parseInt(multiplyCandidate);
			}
		} 
		System.out.println("���� ��� �� : " + multiply);
		System.out.println("����� ���ŵ� ���׽� : " + func);
		
		double mit;
		int jisu;
		int powSymbolIndex = func.indexOf('^');
		int xIndex = func.indexOf('x');
		// ���� e�� ��� Exception ó���� �������� �� ����
		try {
			mit = (double) Integer.parseInt(func.substring(0, powSymbolIndex));
		} catch (Exception e) {
			mit = 2.71;
		}

		// ������ 1�� ��� Exception ó���� �������� �� ����
		try {
			jisu = Integer.parseInt(func.substring(powSymbolIndex + 1, xIndex));
		} catch (Exception e) {
			jisu = 1;
		}

		result = multiply * Math.pow(mit, jisu * value);
		System.out.println("���� ���� ���׽� ��� �� : " + result);
		return result;
	}

	public double getExponentialIntegraledValue(String func, int from, int until) {
		double result = 0;
		result += getExponentialSpecificValue(func, until) - getExponentialSpecificValue(func, from);
		return result;
	}

	public static void main(String[] args) {

	}

	
	
}
