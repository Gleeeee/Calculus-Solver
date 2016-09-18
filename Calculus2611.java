package teamProject;

public class Calculus2611 {

	public static int setBase(double[] expo, String exp) {
		
		//������� ������ �� ���� ����� expo �迭�� �����Ѵ�.
		int index = 0;
		for (int i = 0; i < exp.length(); i++) {
			char cur = exp.charAt(i);
			if (cur == 'x') {
				if (exp.charAt(i-1) == '+') {
					//����� 1�� ���� ���� ó���Ѵ�.
					expo[index] = 1;
				} else {
					//����� 1�� �ƴ� ���� char ���� int ������ �����Ѵ�.
					expo[index] = ( exp.charAt(i - 1) - 48 );
				}
				index++;
			}
		}
		
		//������� expo �迭�� �� �������� �����Ѵ�.
		expo[index] = (exp.charAt(exp.length()-1)-48);
		
		System.out.print("�Էµ� ���(���� ���� ��) : ");
		for (int i = 0; i <= index; i++) {
			System.out.print(expo[i] + ", ");
		}
		System.out.println("(�ְ������� ���� : " + index + ")");
		
		return index;
		 
	}
	
	public static void calcUp(double[] expo, int cnt) {
		//�������� ���
		int index;
		
		for (int i = 0; i <= cnt; i++) {
			index = cnt - i;
			expo[i] = expo[i] / (index + 1);
		}
		
		System.out.print("���е� ���(���� ���� ��) : ");
		for (int i = 0; i <= cnt; i++) {
			System.out.print(expo[i] + ", ");
		}
		System.out.print("C, ");
		System.out.println("(�ְ������� ���� : " + (cnt + 1) + ")");
	}
	
	public static double power(int a, int b) {
		//a�� b���� ��ȯ
		double result = 1;
		for (int i = 0; i < b; i++) result *= a;
		return result;
	}
	
	public static double topos(double a) {
		//a�� ���� ��ȯ
		if (a > 0) return a;
		else return a * (-1);
	}
	
	public static double polynomial(double[] expo, int cnt, int start, int end) {
		//����, �Ʒ��� ���� ��� ����
		double tmp_start = 0;
		double tmp_end = 0;
		double result = 0;
		
		for (int i = 0; i <= cnt; i++) {
			tmp_end += expo[i] * power(end, cnt + 1 - i);
			tmp_start += expo[i] * power(start, cnt + 1 - i);
		}
		
		//���밪
		result = topos(tmp_end - tmp_start);
		
		return result;
	}
	
	public static double triangle(double[] expo, int cnt, int start, int end) {
		double result = 0;
		return result;
	}
	
	public static double exponent(double[] expo, int cnt, int start, int end) {
		double result = 0;
		return result;
	}
	
	public static void printResult(double result) {
		//���� �κа� �Ҽ� �κ� �и�
		int intPart = (int)result;
		double doublePart = result - intPart;
		
		//Wrapper�� �̿��� int�� double�� String���� ��ȯ
		String intPartStr = Integer.toString(intPart);
		String doublePartStr = Double.toString(doublePart);
		
		//���
		System.out.print("���� ��� : ");
		System.out.println(intPartStr + doublePartStr.substring(1,5));
	}
	
	public static void main(String[] args) {
		
		// ���� exp�� '2x^4+x^3+3x^2+4x+5' ���·� ����ڿ��� �Է¹޴´�.
		// �׽�Ʈ ���� exp, start, end�� �̸� ������
		String exp = "2x^4+x^3+3x^2+4x+5";
		int start = 3, end = 4;
		double result;
		
		//�� ������ �������� ����� �����ϴ� �迭
		//������ ���� ������� index 0��°���� ����ȴ�.
		double[] expo = new double[100];
	
		//�������� ���
		int cnt = setBase(expo, exp);
		calcUp(expo, cnt);
		
		//�������п� �� ���� (������ ���)
		result = polynomial(expo, cnt, start, end);
		
		//�Ҽ��� 3�ڸ������� ���
		printResult(result);
	}

}
