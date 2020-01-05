1.修改docker仓库资源的地址
      阿里云获取docker仓库资源的地址https://cr.console.aliyun.com/cn-qingdao/mirrors
  https://wuxw2xue.mirror.aliyuncs.com
2.开启docker中2375端口

3.maven中settings.xml文件加入
  <pluginGroups>
   <pluginGroup>com.spotify</pluginGroup>
  </pluginGroups>
  
3.pom.xml 文件添加docker插件
	注意：
	1.1、${docker.image.prefix} 是镜像的前缀
	1.2、${project.artifactId} 是镜像名字
	1.3、${project.version} 版本号，此处也用来当做镜像的版本号
	1.4、docker-maven-plugin 使用可自行百度。
	
4.src/main/docker 目录下新增文件 Dockerfile，内容如下：
	FROM frolvlad/alpine-oraclejdk8:slim
	ADD  business.jar app.jar
	ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
	
5.以上的配置可以把一个服务打包成镜像，只需要执行
	mvn package docker:build




/*******************jenkins 部署配置方式：********************************/
环境准备
1.jenkins下载地址
  http://mirrors.jenkins-ci.org/war/latest/jenkins.war
     直接运行java –jar jenkins.war
2.maven安装
3.svn安装
4.jdk安装
5. docker安装

1.编写代码，修改代码
2.提交代码到svn
3.Jenkins自动检测到svn代码更新，从svn拉取最新代码
4.Jenkins自动编译
5.Jenkins自动打成tomcat下能运行的war包
6.Jenkins自动上传war包到docker宿主机目录
7.Jenkins自动构建web容器镜像，包含项目demo
8.Jenkins自动启动镜像，变成容器，映射端口
9.最后就有项目运行的界面提供了