# Vi, Java, Ant及Junit的自学报告   
### Written By 16340256谢玮鸿
---

* **Vi编辑器**  
vi编辑器是Linux系统下标准的文本编辑器，vi编辑器通常被简称为vi，而vi又是visual editor的简称。它在Linux上的地位就像Edit程序在DOS上一样。它可以执行输出、删除、查找、替换、块操作等众多文本操作，而且用户可以根据自己的需要对其进行定制，这是其他编辑程序所没有的。  
进入vi编辑器很简单，在Terminal中输入vi 文件名后即可进入vi全屏编辑,如现在要新创建一个test.c并编辑，输入下面命令即可。
    ```
    $ vi test.c
    ```
    vi 编辑器并不是一个排版程序，它不像Word或WPS那样可以对字体、格式、段落等其他属性进行编排，它只是一个文本编辑程序。没有菜单，只有命令，且命令繁多。vi有3种基本工作模式：命令行模式、插入模式和底行模式，接下来就简单说明一下这三个工作模式。　　

   * **命令行模式**  
      用户在用vi编辑文件时，最初进入的模式，可以用于移动光标、删除字、进行复制粘贴等操作。  
      在命令行下输入字母是没有任何显示的，一般是直接按功能键执行命令，比较常用的命令有:  
      * 进入插入模式
          按[a]　(append)  进入编辑状态，从当前光标之后位置开始插入键盘输入的字符;    
          按[i]　(insert)  进入编辑状态，从当前光标位置开始插入键盘输入的字符;  
          按[o]  (open)   进入编辑状态，并插入一行，光标移动到新行行首，开始插入键盘输入的字符;  
      * 移动光标  
          移动光标有多种指令，简单的上下左右移动可以直接用方向键移动，正规的做法使用小写字母　  
          [h]左移;    [j]上移;    [k]下移;    [l]右移;  
      * 删除文字  
          按[ｘ]  　删除当前光标之后位置的一个字符;  
          按[Ｘ]　删除当前光标位置的一个字符;  
          输入[dd]    删除当前光标所在行;  
      * 复制粘贴  
          输入[yw]　将光标位置开始到字尾的所有字符复制到缓冲区中;  
          输入[yy]　将光标所在行的所有字符复制到缓冲区中;  
          输入[p]　　将缓冲区内的字符贴到光标所在位置;  
      * ......  
   * **插入模式**  
          在此模式下可以进行文本编辑，按Esc可以返回命令行模式。  
          值得注意的是，由于Ubuntu预装的是vim-tiny，所以在vi的编辑模式下，按方向键不能移动光标而是输出ABCD，以及退格键不能正常删除字符，解决方法则是卸载vim-tiny，安装vim-full。
      ```
      sudo apt-get remove vim-common
      sudo apt-get install vim
      ```

   * **底行模式**  
      在此模式下光标位于屏幕底行，可以设置编辑环境，还可以进行保存文件、退出vi等操作。　　
      在命令行模式下输入:即可进入底行模式，底行模式用得最多的就是保存退出命令，以及一些常用命令均如下所示:
      * [:set nu] 文本中显示行号;
      * [:#] 跳转到第#行，#代表一个数字;
      * [:/key] 搜索(往后),key代表你要搜索的关键字，会将光标指向关键字处，按[n]往后查找下一个关键字;
      * [:?key] 搜索(往前),key代表你要搜索的关键字，会将光标指向关键字处，按[n]往前查找下一个关键字;
      * [w] 保存文件;
      * [q]　退出vi
      * [wq] 保存并退出vi.

   以上便是我关于vi编辑器学习到的基本内容，结合网上的教学资料和一些视频并实际操作后，基本能够掌握vi编辑器的使用了。虽然刚开始接触的时候很头疼，尤其是插入模式下因为vim-tiny的缘故感觉真是丧心病狂，光标不能移，退格不能删，令人感觉很崩溃，还好找到了解决方案，一下子明朗了不少。除了vi外，还有更强大的vim，可以支持多种插件，在以后我还得多多努力学习。顺便贴一张学习vi编辑器时的图哈哈哈。

  ![pic-vi编辑](https://images-cdn.shimo.im/BVEBGoRjswsGYNUA/image.png!thumbnail)

---

* **jdk环境下的java语言**  
    感觉又像是回到了大一实训刚接触Linux系统的时候，如同学习g++/gcc编译器和gdb调试工具，这次是要学习在jdk环境下学习java语言并完成HelloWorld的编译运行。有了之前的经验，这次的学习过程可以算是较简单的。云平台下jdk环境已经配置好了，确认一下版本信息后，直接新建一个Helloworld.java文件，完成第一个java程序。  
**确认环境**  
![pic-确认环境](https://images-cdn.shimo.im/K0D765h8yI8UX1qw/image.png!thumbnail)  
**完成第一个java程序**

  ```java
  public class Helloworld{
        public static void main(String args[]){
          System.out.println("HelloWorld.\n");
        }
  }
  ```  
  **编译运行helloworld**  
  ![pic-编译运行helloworld](https://images-cdn.shimo.im/8VSMcQDqCMEKajEX/image.png!thumbnail)  

---

* **Ant**  
    Ant是一个Apache基金会下的跨平台的构件工具，它可以实现项目的自动构建和部署等功能，而且具备很多优点（见下）。在这次的学习中，主要是熟悉怎样将Ant应用到Java项目中，让它简化构建和部署操作。  
    >   跨平台   --因为ant是使用java实现的，所以它跨平台  
    使用简单 --与ant的兄弟make比起来  
    语法清晰 --同样是和make相比  
    功能强大 --ant能做的事情很多，可能你用了很久，你仍然不知道它能有多少功能。当你自己开发一些ant插件的时候，你会发现它更多的功能。

   同样的，在云平台下Ant已经配置好了，直接开始构建helloworld项目。  
   当开始一个新的项目时，首先应该编写Ant构建文件。构建文件定义了构建过程，并被团队开发中每个人使用。Ant构建文件默认命名为build.xml(或取其他的名字)，在运行的时候会把这个命名当作参数传给Ant。构建文件可以放在任何的位置。一般做法是放在项目顶层目录中，这样可以保持项目的简洁和清晰。下面是一个典型的项目层次结构。  
(1) src——存放文件。  
(2) class——存放编译后的文件。  
(3) lib——存放第三方JAR包。  
(4) dist——存放打包，发布以后的代码。  
 **编写build.xml** 
  ```xml
  <?xml version="1.0"?>  

  <!--工程的名字是HelloWorld-->  
  <project name="HelloWorld" default="run" basedir=".">  

     <!-- 定义资源，包括src、目标文件以及jar文件的目录 -->  
     <property name="n_src" value="src"/>  
     <property name="n_classes" value="classes"/>  
     <property name="n_jar" value="jar"/>  

     <!-- 定义第一个目标：初始化，新建目标文件目录 -->  
     <target name="init">  
     <mkdir dir="${n_classes}"/>  
     </target>  

     <!-- 定义第二个目标：编译源文件，把目标文件放入classes/ -->  
     <target name="compile" depends="init">  
     <javac srcdir="${n_src}" destdir="${n_classes}"/>  
     </target>  

     <!-- 定义第三个目标：构建jar文件 -->  
     <target name="build" depends="compile">  
     <jar jarfile="${n_jar}" basedir="${n_classes}"/>  
     </target>  

     <!-- 定义最后一个目标：运行文件 -->  
     <target name="run" depends="build">  
     <java classname="Helloworld" classpath="${n_jar}"/>  
     </target>  

  </project> 
  ```    
  > **xml中元素解释：**  
  [default]   ant默认执行的参数  
  [basedir]   要打包文件所在目录  
  [mkdir]     建立目录  
  [javac]     编译命令  
  [java]      运行命令  
  [classname] 要运行的类  
  [classpath] 要运行的类jar文件的路径  
  [srcdir]    源文件所在目录  
  [destdir]   编译后目标文件所在目录  
  [jar]       打包命令  
  [jarfile]   编译后生成的jar文件  
  [depends]   target之间相互依赖的关系  

  **把build.xml和包含Helloworld.java的src文件夹放在同一个目录**  
  ![pic-文件结构](https://images-cdn.shimo.im/Zj7aagok47Ybkhio/image.png!thumbnail)  
  **在终端打开至该目录，输入指令ant构建项目，并能在控制台上看到Helloworld运行结果**  
  ![pic-BuildUp](https://images-cdn.shimo.im/9CNqlgbtVHUwQWe9/image.png!thumbnail)  
  **成功构建项目后的主目录**
  ![pic-构建后文件结构](https://images-cdn.shimo.im/VcTMm102yAA5FTHc/image.png!thumbnail)
  
  ---
  
* **JUnit**  
Junit是一个开源的Java单元测试框架。单元测试是用来对一个模块、一个函数或者一个类来进行正确性检验的测试工作。通俗的讲，就是我写了一个类，这个类是要给别人用的，在别人用之前要测试这个类是否有bug，这样的测试就是单元测试。JUnit用于编写和运行可重复的测试，它是用于单元测试框架体系xUnit的一个实例（用于java语言），包括以下特性：  
  > 用于测试期望结果的断言（Assertion）  
  用于共享共同测试数据的测试工具  
  用于方便的组织和运行测试的测试套件  
  图形和文本的测试运行器  

  那么现在开始进行HelloWorld的单元测试：  
  **step 1**  
  在Eclipse中创建一个Java project(HelloWorld)，在这个project建立一个package，在package中建立一个开发的类（HelloWorld.java）。   
  ![pic-HelloWorld类](https://images-cdn.shimo.im/OcRZBSNUQikHPdMF/image.png!thumbnail)  
  **step 2**  
  在project中建立另一个package(HelloWorldTest)，在package中点击鼠标右键，建立一个JUnit Test Case，即建立测试类（HelloWorldTest.java）。在Class Under Test中点击Browse，选择HelloWorld这个类作为测试对象,，点击OK确定后返回上一级界面，然后点击next。  
  ![pic-HelloWorldTest类](https://images-cdn.shimo.im/gNrkgFpplpIDvVHC/image.png!thumbnail)  
  弹出的对话框中还可以选择对这个类中的哪个方法进行测试。这里选择测试Say()方法，点击Finish.  
  ![pic-选择测试方法](https://images-cdn.shimo.im/uThfC4jQN70bL100/image.png!thumbnail)  
  此时会弹出对话框提示“JUnit4 is not in the build path”,这时选择手动添加。在右上选择“Libraries”标签，之后点击“Add Library…”按钮，选择JUnit4，然后确定即可。  
  **step 3**  
  修改测试代码并测试。在testSay）方法中修改成如下的测试代码，然后右键点击HelloWorldTest.java，选择Run As中的JUnit Test，出现如图的绿框，测试成功。  
  值得注意的是，Failure是指测试失败，Error是指测试程序本身出错。
  ![pic-修改后的测试代码及测试结果](https://images-cdn.shimo.im/EGQUYFA0Ofc4AeF8/image.png!thumbnail)  
  至此，HelloWorld单元测试完成。
    
  ---
  **小结**  
  以上全部便是这次的自学报告，前前后后学习了8个小时，收获了不少。不过说实话，学一天学的很累，而且还有其他任务，感觉第一周就异常充实，希望快点解放吧哈哈哈。
