package test;


public class Strtransform {
	public boolean chkTransform(String A, int lena, String B, int lenb){
		if(A == null || B == null || A.length() != B.length())
			return false;
		char[] s1 = new char[256];
		char[] s2 = new char[256];
		for(int i = 0;i < A.length(); i++){
			s1[A.charAt(i)]++;
			s2[B.charAt(i)]++;
		}
		if(s1.length != s2.length)
			return false;
		for(int i = 0;i < s1.length; i++){ //���Ҫ���ַ��������Ƶ�ζ���ȣ���ôs1��s2��Ӧλ��ֵ���
			if(s1[i] != s2[i])
				return false;
		}
		return true;
//		HashMap<Character, Integer> s1 = new HashMap<>();
//		HashMap<Character, Integer> s2 = new HashMap<>();
//		for (int i = 0; i < A.length(); i++) {
//			char keya = A.charAt(i);
//			char keyb = B.charAt(i);
//			Integer freqa = s1.get(keya);
//			Integer freqb = s2.get(keyb);
//			s1.put(keya, freqa == null ? 1 : freqa + 1); 
//			s2.put(keyb, freqb == null ? 1 : freqb + 1);
//		}
//		Set<Character> sa = s1.keySet();
//		Set<Character> sb = s2.keySet();
	}
}
