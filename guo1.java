
import java.util.Scanner;

public class guo1 {
	public static void main(String[] args) {
		// �������壺һ�鶩����Ϣ
		Scanner input = new Scanner(System.in);
		String[] names = new String[4];// ������
		String[] dishmess = new String[4];// ��Ʒ��Ϣ
		int[] times = new int[4];// �ͻ�ʱ��
		String[] adresses = new String[4];// �ͻ���ַ
		int[] states = new int[4];// ����״̬ 0����Ԥ�� 1�������
		double[] sumprices = new double[4];// �ܽ��

		// ��ʼ����������
		names[0] = "����";
		dishmess[0] = "������2��";
		times[0] = 12;
		adresses[0] = "���·209��";
		states[0] = 1;
		sumprices[0] = 70.0;

		names[1] = "����";
		dishmess[1] = "��������1��";
		times[1] = 12;
		adresses[1] = "���·209��";
		states[1] = 0;
		sumprices[1] = 31;

		// �������壬һ���Ʒ��Ϣ
		String[] dishNames = { "������", "������", "��������" };
		double[] prices = { 35.0, 38.0, 25.0 };
		int[] praiseNums = new int[3];

		// ���
		System.out.println("��ӭʹ�óԻ����˶���ϵͳ");
		int num = -1;
		do {
			System.out.println("***************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ɾ������");
			System.out.println("4.ǩ�ն���");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("***************");

			System.out.print("��ѡ��");

			int choose = input.nextInt();
			boolean isadd = false;// �絽һ��Ϊ�յ�λ��
			switch (choose) {
			case 1:
				// ��Ҫ����
				System.out.println("*******��Ҫ����*******");
				// ����Ҫ����������
				for (int i = 0; i < names.length; i++) {

					if (names[i] == null) {
						isadd = true;
						// ִ�в������
						System.out.println("���\t��Ʒ��\t�۸�\t������");
						for (int j = 0; j < praiseNums.length; j++) {
							String price = prices[j] + "Ԫ";
							String praise = praiseNums[j] + "��";
							System.out.println((j + 1) + "\t" + dishNames[j]
									+ "\t" + price + "\t" + praise);
						}
						// ������ �Լ�����
						System.out.print("��ѡ�������Ĳ�Ʒ��ţ�");
						int choosedish = input.nextInt();
						while (choosedish < 1 || choosedish > 3) {
							System.out.println("�������� ����������");
							choosedish = input.nextInt();
						}
						System.out.print("ѡ������������");
						int number = input.nextInt();
						String dishMeg = dishNames[choosedish - 1] + " "
								+ number + "��";
						// ���붩���˵�����
						System.out.print("�����붩���˵�������");
						String name = input.next();
						// �Ͳ�ʱ��
						System.out.print("�������Ͳ�ʱ�䣨10--20��");
						int time = input.nextInt();
						while (time < 10 || time > 20) {
							System.out.print("����������� ����������");
							time = input.nextInt();
						}
						// �Ͳ͵�ַ
						System.out.print("�������Ͳ͵�ַ��");
						String adress = input.next();
						// ����ͷ�
						double sumPrise = prices[choosedish - 1] * number;
						// �Ͳͷ�
						double deliChange = sumPrise > 50 ? 0.0 : 6;
						// ��ʾ������Ϣ
						System.out.println("���ͳɹ�");
						System.out.println("�㶨����" + dishMeg);
						System.out.println("������" + name);
						System.out.println("�㶨��ʱ��" + time + "��");
						System.out.println("�Ͳ͵�ַ" + adress);
						System.out.println("���M:" + sumPrise + ",�Ͳͷѣ�"
								+ deliChange + "Ԫ");
						System.out.println("�ܽ�" + (sumPrise + deliChange)
								+ "Ԫ");
						// ��������
						names[i] = name;
						dishmess[i] = dishMeg;
						times[i] = time;
						adresses[i] = adress;
						sumprices[i] = sumPrise + deliChange;
						states[i]=0;

						break;
					}
				}
				if (!isadd) {
					System.out.println("�Բ������Ķ�������");
				}
				break;
			case 2:
				// �鿴�ʹ�
				System.out.println("*********�鿴�ʹ�********");
				System.out.println("���\t������\t������Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t״̬");
				// ���
				for (int j = 0; j < names.length; j++) {
					if (names[j] != null) {
						String time = times[j] + "��";
						String summoney = sumprices[j] + "Ԫ";
						String state = states[j] == 0 ? "��Ԥ��" : "�����";
						System.out.println((j + 1) + "\t" + names[j] + "\t"
								+ dishmess[j] + "\t" + time + "\t"
								+ adresses[j] + "\t" + summoney + "\t" + state);

					}
				}
				break;
			case 3:
				// ɾ������
				System.out.println("******ɾ������******");
				System.out.println("������Ҫɾ���Ķ������");
				int delid = input.nextInt();
				boolean isFand2 = false;
				int delidaddress = -1;// ɾ�������±�
				// for star
				for (int j = 0; j < names.length; j++) {
					if (names[j] != null && states[j] == 1 && delid == j + 1) {
						delidaddress = j;
						isFand2 = true;
						// ִ��ɾ������

						for (int i = delidaddress + 1; i < names.length; i++) {
							names[i - 1] = names[i];
							dishmess[i - 1] = dishmess[i];
							times[i - 1] = times[i];
							adresses[i - 1] = adresses[i];
							states[i - 1] = states[i];
						}
						names[names.length - 1] = null;
						dishmess[dishmess.length - 1] = null;
						times[times.length - 1] = 0;
						adresses[adresses.length - 1] = null;
						states[states.length - 1] = 0;
						System.out.println("ɾ���ɹ�");

						break;
					} else if (names[j] != null && states[j] == 0
							&& delid == j + 1) {
						System.out.println("��ѡ��Ķ���noǩ�գ�����ɾ��");
						isFand2 = true;
						break;
					}
				}// for end
				if (!isFand2) {
					System.out.println("�Բ��� ���˶���������");
				}

				break;
			case 4:
				// ǩ�ն���
				System.out.println("******ǩ�ն���******");
				System.out.print("������Ҫǩ�յĶ������:");
				int signOrderId = input.nextInt();
				boolean isFand = false;
				for (int j = 0; j < names.length; j++) {
					if (names[j] != null && states[j] == 1
							&& signOrderId == j + 1) {
						System.out.println("��ѡ��Ķ����Ѿ����ǩ�գ�������ǩ��");
						isFand = true;
						break;
					} else if (names[j] != null && states[j] == 0
							&& signOrderId == j + 1) {
						states[j] = 1;// ��Ϊ�����
						System.out.println("ǩ�ճɹ�");
						isFand = true;
						break;
					}
				}
				// �����ж�
				if (!isFand) {
					System.out.println("�Բ��� ���ζ���������");
				}
				break;
			case 5:
				// ��Ҫ����
				System.out.println("*******��Ҫ����******");
				System.out.println("���\t��Ʒ��\t����\t");
				for (int j = 0; j < praiseNums.length; j++) {
					String price = prices[j] + "Ԫ";
					String praise = praiseNums[j] + "��";
					System.out.println((j + 1) + "\t" + dishNames[j] + "\t"
							+ price + "\t" + praise);
				}
				System.out.print("������Ҫ���޵���Ʒ��ţ�");
				int choose2 = input.nextInt();
				praiseNums[choose2 - 1]++;
				System.out.println("���޳ɹ�");
				System.out.println(dishNames[choose2 - 1] + " "
						+ praiseNums[choose2 - 1] + "��");
				break;
			case 6:
				// �˳�ϵͳ
				break;

			default:
				break;
			}
			if (choose < 1 || choose > 5) {
				break;
			}

			System.out.print("����0����");
			num = input.nextInt();

		} while (num == 0);
		System.out.println("ллʹ�ã���ӭ�´�ʹ�ã�");
	}
}
