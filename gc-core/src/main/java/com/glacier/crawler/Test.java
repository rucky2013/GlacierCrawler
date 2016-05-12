package com.glacier.crawler;

import com.glacier.crawler.crawler.Crawler;
import com.glacier.crawler.entity.Task;
import com.glacier.crawler.login.Login;


/**
 * Created by Glacier on 16/4/26.
 */
public class Test {

//    public static void main(String[] args) {
//        String url = "http://blog.csdn.net/u010989191/article/details/51308554";
//        String pattern = "http://blog.csdn.net/([^\\s]*)/([^\\s]*)/([^\\s]*)/(\\d*)";
//        System.out.println(Pattern.matches(pattern, url));
//    }

    public static void main(String[] args) throws Exception {
        Crawler crawler = Crawler.getInstance(Crawler.BASE);

//        Login login = new Login();
//        login.setLoginURL("http://weibo.cn/?vt=4");
//        login.addHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.86 Safari/537.36");
//        login.addHeader("Cookie", "SUHB=0oUZ6zWr4QWEwj; _T_WM=f8d0c5b50455beed0627b927cabd5985; SUB=_2A256KHT-DeRxGeNM41AY8CzJzDSIHXVZ0xy2rDV6PUJbrdAKLUT2kW1LHes5ePY-fna55BmbG-QbXEsLyFWKEA..; gsid_CTandWM=4u7N18571dO9GaRZ43Fp6mak69k");
//        login.useCookie();
//        String login_result = crawler.login(login);
//        System.out.println(login_result);
//
//        Task task = new Task("http://weibo.cn/?vt=4");
        Task task = new Task("http://blog.csdn.net/");
//        Task task = new Task("http://studygolang.com/static/pkgdoc/index.html");
//        task.addPattern("http://studygolang.com/static/pkgdoc/([^\\s]*)");
//        task.setCrawlerType(Task.TYPE_TASK_ALL);
        task.setCrawlerType(Task.TYPE_TASK_PATTERN);
        task.addPattern("http://blog.csdn.net/([^\\s]*)/([^\\s]*)/([^\\s]*)/([0-9]{8})#([^\\s]*)", "com.glacier.crawler.processor.BasePageProcessor");
        task.addPattern("http://blog.csdn.net/([^\\s]*)/([^\\s]*)/([^\\s]*)/([0-9]{8})", "com.glacier.crawler.crawler.processor.BasePageProcessor");
        crawler.scheduler().setKey("csdn");
        crawler.scheduler().clear();
        crawler.scheduler().push(task);
        crawler.setThread(20);
        crawler.start();
    }

}
