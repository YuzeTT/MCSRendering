import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Mincraft 3D皮肤生成器 V1.0");
        String SkinID = "0";
        while (true) {
            Scanner ID = new Scanner(System.in);
            System.out.println("请输入NameMC皮肤ID：");
            SkinID = ID.nextLine();
            //System.out.println(SkinID);
            int setID = SkinID.length();

            //判断是否为空
            if (SkinID != null && !"".equals(SkinID)) {
                System.out.println("正在识别中");
                //延迟1s
                TimeUnit.SECONDS.sleep(1);
                //判断ID位数
                if (setID == 16) {
                    System.out.println("识别成功！正在加载相关API...");
                } else {
                    System.out.println("无法识别为NameMC皮肤ID");
                    //延迟1s
                    TimeUnit.SECONDS.sleep(1);
                    continue;
                }
                break;
            } else {
                System.out.println("请输入内容！\n");
                //延迟1s
                TimeUnit.SECONDS.sleep(1);
                continue;
            }
        }

        //https://render.namemc.com/skin/3d/body.png?skin=410f42851119897e&model=classic&theta=-30&phi=20&time=82&width=600&height=800
        //定义皮肤样式
        //延迟1s
        TimeUnit.SECONDS.sleep(1);
        System.out.println("皮肤样式：");
        System.out.println("1：Steve(默认)");
        System.out.println("2：Alex");
        System.out.println("请选择(仅输入序号，留空使用默认)：");
        Scanner ID2 = new Scanner(System.in);
        String model = ID2.nextLine();
        //System.out.println(model);
        //System.out.println(SkinID);
        String mode = "classic";
        String moda = "Steve";

        if (model.equals("2")) {
            mode = "slim";
            moda = "Alex";
        }else {
            mode = "classic";
            moda = "Steve";
        }
        System.out.println(moda);

//        switch (model) {
//            case "1":
//                mode = "classic";
//                moda = "Steve";
//                //break;
//            case "2":
//                mode = "slim";
//                moda = "Alex";
//                //break;
//            default:
//                System.out.println("[ERROR]自动使用默认");

        //410f42851119897e
        //定义左右角度
        System.out.println("请输入左右旋转角度(输入-360到360，顺时针，留空默认：-30)：");
        Scanner ID3 = new Scanner(System.in);
        String ZYJD = ID3.nextLine();

        Integer ZYJDint = 0;
        if (ZYJD.equals("")) {
            ZYJDint = -30;
        } else {
            ZYJDint = Integer.parseInt(ZYJD);
        }
        //System.out.println(ZYJDint);


        //定义上下角度
        System.out.println("请输入上下旋转角度(输入-360到360，留空默认：20)：");
        Scanner ID4 = new Scanner(System.in);
        String SXJD = ID4.nextLine();

        Integer SXJDint = 0;
        if (SXJD.equals("")) {
            SXJDint = 20;
        } else {
            SXJDint = Integer.parseInt(ZYJD);
        }
        //System.out.println(SXJDint);

        //定义脚摆动戳
        System.out.println("请输入脚的摆动戳(输入0到360，留空默认：0：）");
        Scanner ID5 = new Scanner(System.in);
        String JJD = ID5.nextLine();

        Integer JJDint = 0;
        if (JJD.equals("")) {
            JJDint = 0;
        } else {
            JJDint = Integer.parseInt(ZYJD);
        }
        //System.out.println(JJDint);


        System.out.println("渲染尺寸：");
        System.out.println("1：60px X 80px");
        System.out.println("2：120px X 160px");
        System.out.println("3：240px X 380px");
        System.out.println("4：600px X 800px(默认)");
        System.out.println("5：1080px X 800px");
        System.out.println("请输入序号(输入不合法字符自动使用默认尺寸，留空使用默认尺寸)：");
        //        Scanner ID6 = new Scanner(System.in);
        //        String PX = ID6.nextLine();
        //        int PXS = Integer.parseInt(PX);

                //判断尺寸
        /*
        int width = 600;
        int height = 800;
        switch (PXS) {
            //1.60px X 80px
            case 1:
                width = 60;
                height = 80;
                break;
            //2.120px X 160px
            case 2:
                width = 120;
                height = 160;
                break;
            //3.240px X 380px
            case 3:
                width = 240;
                height = 380;
                break;
            //4.600px X 800px(默认)
            case 4:
                width = 600;
                height = 800;
                break;
            //5.1200px X 1600px
            case 5:
                width = 1200;
                height = 1600;
                break;
            default:
                System.out.println("含有非法字符，自动使用默认尺寸。");

        }

         */

        Scanner ID6 = new Scanner(System.in);
        String PX = ID6.nextLine();

        //判断尺寸
        int width = 600;
        int height = 800;
        if (PX.equals("1")) {
            //1.60px X 80px
            width = 60;
            height = 80;
        }else if (PX.equals("2")){
            width = 120;
            height = 160;
        }else if (PX.equals("3")){
            width = 240;
            height = 380;
        }else if (PX.equals("4")){
            width = 600;
            height = 800;
        }else if (PX.equals("5")){
            width = 1080;
            height = 800;
        }else {
            width = 600;
            height = 800;
            System.out.println("自动使用默认尺寸");
        }


            /*
            switch (PX) {
                //1.60px X 80px
                case "1":
                    width = 60;
                    height = 80;
                    break;
                //2.120px X 160px
                case "2":
                    width = 120;
                    height = 160;
                    break;
                //3.240px X 380px
                case "3":
                    width = 240;
                    height = 380;
                    break;
                //4.600px X 800px(默认)
                case "4":
                    width = 600;
                    height = 800;
                    break;
                //5.1200px X 1600px
                case "5":
                    width = 1080;
                    height = 1920;
                    break;
                case "":
                    width = 600;
                    height = 800;
                default:
                    System.out.println("自动使用默认尺寸");
                    */


        //System.out.println("长：" + width);
        //System.out.println("宽：" + height);
        //410f42851119897e


        //https://render.namemc.com/skin/3d/body.png?skin=410f42851119897e&model=classic&theta=-30&phi=20&time=82&width=600&height=800
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("皮肤ID：" + SkinID);
        System.out.println("皮肤样式：" + moda);
        System.out.println("上下旋转角度：" + SXJDint+"°");
        System.out.println("左右旋转角度：" + ZYJDint+"°");
        System.out.println("脚摆动戳：" + JJDint+"fps");
        System.out.println("渲染尺寸：" + width + "px X " + height+"px");
        System.out.println("-----------------------");

        //"https://render.namemc.com/skin/3d/body.png?skin="+SkinID+"&model="+mode+"&theta="+SXJDint+"&phi="+ZYJDint+"&time="+JJDint+"&width="+width+"&height="+height"
        String url = "https://render.namemc.com/skin/3d/body.png?skin="+SkinID+"&model="+mode+"&theta="+ZYJDint+"&phi="+SXJDint+"&time="+JJDint+"&width="+width+"&height="+height;

        //日期
        LocalDate date = LocalDate.now();

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String da = date.format(formatter1);

        //时间
        LocalTime time = LocalTime.now();

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH-mm-ss");
        String ti = time.format(formatter2);

        //合并
        String dati = da+" "+ti;

        String file = dati+".png";

        HttpURLConnection conn = null;
        InputStream inputStream = null;
        BufferedInputStream bis = null;
        FileOutputStream out = null;
        System.out.println("开始渲染");
        try
        {
            File file0=new File(".");
            if(!file0.isDirectory()&&!file0.exists()){
                file0.mkdirs();
            }
            //file0+"\\main.png"
            out = new FileOutputStream(file);
            // 建立链接
            URL httpUrl=new URL(url);
            conn=(HttpURLConnection) httpUrl.openConnection();
            //以Post方式提交表单，默认get方式
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // post方式不能使用缓存
            conn.setUseCaches(false);
            //连接指定的资源
            conn.connect();
            //获取网络输入流
            inputStream=conn.getInputStream();
            bis = new BufferedInputStream(inputStream);
            byte b [] = new byte[1024];
            int len = 0;
            while((len=bis.read(b))!=-1){
                out.write(b, 0, len);
            }
            System.out.println("渲染完成!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(bis!=null){
                    bis.close();
                }
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        //打印文件位置
        System.out.println("文件位于:" +System.getProperty("user.dir")+"\\ "+dati+".png");

        //退出
        Scanner e = new Scanner(System.in);
        System.out.println("请按回车退出或直接关闭窗口");
        String et = e.nextLine();
        }
    }

