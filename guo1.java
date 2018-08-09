
import java.util.Scanner;

public class guo1 {
	public static void main(String[] args) {
		// 数据主体：一组订单信息
		Scanner input = new Scanner(System.in);
		String[] names = new String[4];// 订餐人
		String[] dishmess = new String[4];// 商品信息
		int[] times = new int[4];// 送货时间
		String[] adresses = new String[4];// 送货地址
		int[] states = new int[4];// 订单状态 0；以预定 1；已完成
		double[] sumprices = new double[4];// 总金额

		// 初始化两条订单
		names[0] = "张婷";
		dishmess[0] = "红烧肉2份";
		times[0] = 12;
		adresses[0] = "天成路209号";
		states[0] = 1;
		sumprices[0] = 70.0;

		names[1] = "张婷";
		dishmess[1] = "红烧茄子1份";
		times[1] = 12;
		adresses[1] = "天成路209号";
		states[1] = 0;
		sumprices[1] = 31;

		// 数据主体，一组餐品信息
		String[] dishNames = { "红烧肉", "红烧鱼", "红烧茄子" };
		double[] prices = { 35.0, 38.0, 25.0 };
		int[] praiseNums = new int[3];

		// 框架
		System.out.println("欢迎使用吃货联盟订餐系统");
		int num = -1;
		do {
			System.out.println("***************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.删除订单");
			System.out.println("4.签收订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("***************");

			System.out.print("请选择：");

			int choose = input.nextInt();
			boolean isadd = false;// 早到一个为空的位置
			switch (choose) {
			case 1:
				// 我要订餐
				System.out.println("*******我要订餐*******");
				// 查找要插入是数据
				for (int i = 0; i < names.length; i++) {

					if (names[i] == null) {
						isadd = true;
						// 执行插入操作
						System.out.println("序号\t餐品名\t价格\t点赞数");
						for (int j = 0; j < praiseNums.length; j++) {
							String price = prices[j] + "元";
							String praise = praiseNums[j] + "赞";
							System.out.println((j + 1) + "\t" + dishNames[j]
									+ "\t" + price + "\t" + praise);
						}
						// 输入编号 以及份数
						System.out.print("请选择所定的餐品序号：");
						int choosedish = input.nextInt();
						while (choosedish < 1 || choosedish > 3) {
							System.out.println("输入有误 请重新输入");
							choosedish = input.nextInt();
						}
						System.out.print("选择所定份数：");
						int number = input.nextInt();
						String dishMeg = dishNames[choosedish - 1] + " "
								+ number + "份";
						// 输入订餐人的姓名
						System.out.print("请输入订餐人的姓名：");
						String name = input.next();
						// 送餐时间
						System.out.print("请输入送餐时间（10--20）");
						int time = input.nextInt();
						while (time < 10 || time > 20) {
							System.out.print("你的输入有误 请重新输入");
							time = input.nextInt();
						}
						// 送餐地址
						System.out.print("请输入送餐地址：");
						String adress = input.next();
						// 计算餐费
						double sumPrise = prices[choosedish - 1] * number;
						// 送餐费
						double deliChange = sumPrise > 50 ? 0.0 : 6;
						// 显示订餐信息
						System.out.println("订餐成功");
						System.out.println("你定的是" + dishMeg);
						System.out.println("订餐人" + name);
						System.out.println("你定的时间" + time + "点");
						System.out.println("送餐地址" + adress);
						System.out.println("餐費:" + sumPrise + ",送餐费："
								+ deliChange + "元");
						System.out.println("总金额：" + (sumPrise + deliChange)
								+ "元");
						// 保存数据
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
					System.out.println("对不起，您的订单已满");
				}
				break;
			case 2:
				// 查看餐袋
				System.out.println("*********查看餐袋********");
				System.out.println("序号\t订餐人\t订餐信息\t\t送餐时间\t送餐地址\t\t总金额\t状态");
				// 输出
				for (int j = 0; j < names.length; j++) {
					if (names[j] != null) {
						String time = times[j] + "点";
						String summoney = sumprices[j] + "元";
						String state = states[j] == 0 ? "已预订" : "已完成";
						System.out.println((j + 1) + "\t" + names[j] + "\t"
								+ dishmess[j] + "\t" + time + "\t"
								+ adresses[j] + "\t" + summoney + "\t" + state);

					}
				}
				break;
			case 3:
				// 删除订单
				System.out.println("******删除订单******");
				System.out.println("请输入要删除的订单序号");
				int delid = input.nextInt();
				boolean isFand2 = false;
				int delidaddress = -1;// 删除订单下表
				// for star
				for (int j = 0; j < names.length; j++) {
					if (names[j] != null && states[j] == 1 && delid == j + 1) {
						delidaddress = j;
						isFand2 = true;
						// 执行删除操作

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
						System.out.println("删除成功");

						break;
					} else if (names[j] != null && states[j] == 0
							&& delid == j + 1) {
						System.out.println("你选择的订单no签收，不能删除");
						isFand2 = true;
						break;
					}
				}// for end
				if (!isFand2) {
					System.out.println("对不起 ，此订单不存在");
				}

				break;
			case 4:
				// 签收订单
				System.out.println("******签收订单******");
				System.out.print("请输入要签收的订单序号:");
				int signOrderId = input.nextInt();
				boolean isFand = false;
				for (int j = 0; j < names.length; j++) {
					if (names[j] != null && states[j] == 1
							&& signOrderId == j + 1) {
						System.out.println("你选择的订单已经完成签收，不能再签收");
						isFand = true;
						break;
					} else if (names[j] != null && states[j] == 0
							&& signOrderId == j + 1) {
						states[j] = 1;// 改为已完成
						System.out.println("签收成功");
						isFand = true;
						break;
					}
				}
				// 条件判断
				if (!isFand) {
					System.out.println("对不起 ，次订单不存在");
				}
				break;
			case 5:
				// 我要点赞
				System.out.println("*******我要点赞******");
				System.out.println("序号\t餐品名\t点赞\t");
				for (int j = 0; j < praiseNums.length; j++) {
					String price = prices[j] + "元";
					String praise = praiseNums[j] + "赞";
					System.out.println((j + 1) + "\t" + dishNames[j] + "\t"
							+ price + "\t" + praise);
				}
				System.out.print("请输入要点赞的商品序号：");
				int choose2 = input.nextInt();
				praiseNums[choose2 - 1]++;
				System.out.println("点赞成功");
				System.out.println(dishNames[choose2 - 1] + " "
						+ praiseNums[choose2 - 1] + "赞");
				break;
			case 6:
				// 退出系统
				break;

			default:
				break;
			}
			if (choose < 1 || choose > 5) {
				break;
			}

			System.out.print("输入0返回");
			num = input.nextInt();

		} while (num == 0);
		System.out.println("谢谢使用，欢迎下次使用！");
	}
}
