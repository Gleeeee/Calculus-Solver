//�̰�ȣ
package ch.dimi.Calculus.util;

class Divider {
    public String[] expo = new String[1000]; //���� �Լ��� ����Ǿ� ����
    public char[] Operator = new char[1000]; //���� �����ڰ� ����Ǿ� ����
    public int cnt = 0;
    
    public void setBase(String exp) {
        int i, p = 0, depth = 0;
        for (i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') depth ++;
            if (exp.charAt(i) == ')') depth --;
            if ((exp.charAt(i) == '+' || exp.charAt(i) == '-') && depth == 0) {
                expo[cnt] = exp.substring(p, i);
                p = i + 1;
                Operator[cnt] = exp.charAt(i);
                cnt++;
            }
        }
        expo[cnt] = exp.substring(p, i);
    }
    
    public static void main(String[] args) {
    	
    }
}