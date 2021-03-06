# 重构：改善既有代码的设计 （Refactoring Improving the Design of Existing-Code）
---
## 第1章 重构，第一个案例
- 重构的第一步：为即将修改的代码建立一组可靠的测试环境。
- 代码分解和重组，删除局部变量，抽取方法，移动方法到使用的数据所属的对象内，修改变量名。
- 使用state模式，运用多态取代条件表达式，修改价格相关的条件逻辑。
---
## 第2章 重构原则
### 2.1 何为重构
* 名词形式定义：对软件内部结构的一种调整，目的是在**不改变软件可观察行为**的前提下，提高其可理解性，降低其修改成本。
* 动词形式定义：使用一系列重构手法，在**不改变软件可观察行为**的前提下，调整其结构。
### 2.2 为何重构
* 重构改进软件设计。
* 重构使软件更容易理解。
    * 后期更新维护更加容易。
    * 提高理解层次从代码层面到设计层面。
* 重构帮助找到bug。
* 重构提高编程速度。
### 2.3 何时重构
**三次法则**：事不过三，三则重构。
* 添加新功能时重构。
* 修补错误时重构。
* 复审代码时重构。
### 2.4 怎么对经理说
* 不要告诉经理，如果自己认为最快完成的方式就是重构，那么就进行重构。
#### 2.4.1 间接层的价值
* 允许逻辑共享
* 分开解释意图和实现
* 隔离变化
* 封装条件逻辑
### 2.5 重构的难题
#### 2.5.1 数据库
* 问题：应用程序与数据库耦合紧密，数据迁移过程漫长而繁琐。
* 解决方法
    * 非对象数据库：在对象模型和数据库模型中间插入一个分隔层，隔离两个模型各自的变化。
    * 对象数据库：数据未被转移前就先运用访问函数造成“数据已经转移”的假象，一旦确定知道数据应该在何处，就可以一次性迁移过去。
#### 2.5.2 修改已发布的接口
* 同时维护新旧两个接口，直到所有的用户都有时间对这个变化做出反应。让旧接口调用新接口，旧函数调用新函数，不要复制函数实现。
* 除非真的有必要，否则不要发布接口。
#### 2.5.3 难以通过重构手法完成的设计改动
* 选择设计方案时，考虑重构为另一个设计的难度，尽量选择简单易重构的设计。
#### 2.5.4 何时不该重构
* 应该重新编写所有代码时，不应该重构而应该重写。
* 项目接近最后期限时，不应该重构。
### 2.6 重构与设计
* 重构可以带来更简单的设计，同时又不损失灵活性，这也降低了设计过程的难度，减轻了设计压力。
### 2.7 重构与性能
* 编写快速软件：首先写出可调的软件，然后调整它以求获得足够速度。
* 在性能优化阶段（开发后期），找出性能热点的代码，持续关注，反复测试优化。
* 构造良好的程序对性能优化的帮助：
    * 可帮助空出更多时间处理性能问题。
    * 可进行更细粒度的代码分析，帮助调整性能。
* 短期来看，重构使得软件变慢，但它使得优化阶段的性能调整更加容易，最终会得到更好效果。
---
## 第三章 代码的坏味道
### 3.1 重复代码（Duplicated Code）
* 特点
    * 同一个类的两个函数具有相同的表达式。
    * 两个互为兄弟的子类内含有相同的表达式。
    * 两个毫不相关的类出现重复代码。
* 方案：提炼重复代码，抽取为通用方法。
### 3.2 过长函数（Long Method）
* 每当感觉需要以注释来说明点什么的时候，我们就把需要说明的东西写进一个独立函数中，并以其用途（而非实现手法）命名。
### 3.3 过大的类（Large Class）
* 如果一个类中有太多实例变量，那么可以多次使用Extract Class（提炼类）和Extract Subclass（提炼子类）方法。
### 3.4 过长参数列（Long Parameter List）
* 太长的参数列难以理解，可以用函数或者对象取代参数传递到函数当中。
### 3.5 发散式变化（Divergent Change）
* 如果某个类经常应为不同的原因在不同的方向上发生变化，那么就可以分为多个类去处理。
* 针对某一外界变化的所有相应修改，都只应该发生在单一类中，而这个新类内的所有内容都应该反应此变化。
### 3.6 霰弹式修改（Shotgun Surgery）
* 如果每次变化都需要修改不同类的多处，就可以考虑将需要修改的代码放进同一个类。
### 3.7 依恋情结（Feature Envy）
* 将总是一起变化的东西放在一块，如果有例外出现，就搬移那些行为，保持变化只在一地发生。
### 3.8 数据泥团（Data Clumps）
* 可以将两个类中的相同字段、许多函数签名中的相同参数提炼到一个独立对象当中。
### 3.9 基本类型偏执（Primitive Obsession）
* 对象的价值之一：它们模糊（甚至打破）了横亘于基本数据和体积较大的类之间的界限。
* 可以将原本单独存在的数据值替换为对象，从而走出传统的洞窟，进入对象的世界。
### 3.10 switch惊悚现身（Switch Statements）
* 应该考虑使用多态来替换switch语句。
* 如果只是在单一函数中有选择事例，就可以将switch中的行为抽取为方法。
### 3.11 平行继承体系（Parallel Inheritance Hierarchies）
* 每当为某个类添加一个子类，必须也为另一个类相应增加一个子类，即产生平行继承。
* 消除平行继承的策略是：让一个继承体系的实例引用另一个继承体系的实例。
### 3.12 冗赘类（Lazy Class）
* 如果一个类的作用或者所做的工作很少，那就考虑折叠继承体系或者将类内联化。
### 3.13 夸夸其谈未来性（Speculative Generality）
* 如果所有的装置都会被用到，那么就值得做；如果做不到，就不值得，不要过分考虑和过分设计。
### 3.14 令人迷惑的暂时字段
* 可以将为特殊情况而设置的暂时变量及相关的放置进一个新的类当中进行维护。
### 3.15 过度耦合的消息链（Message Chains）
* 消息链过度耦合时，对象间的关系发生任何变化，客户端都必须得做出修改。
* 应该先观察消息链最终结果的用处，看看能否将使用该对象的代码提炼到一个独立函数当中，再搬移这个函数到消息链。
### 3.16 中间人（Middle Man）
* 如果过度运用委托，那么就应该在调用端直接获取实则对象，运用实则对象进行函数调用。
### 3.17 狎昵关系（Inappropriate Intimacy）
* 狎昵：指过于亲近而态度不庄重
* 过分狎昵的类必须拆散，将双向关联改为单向关联或将二者的共同点提炼到一个新的类当中。
### 3.18 异曲同工的类（Alternative Classes with Different Interfaces）
* 如果两个函数作用相同命名却不同，就要考虑更具它们的用途重新命名，如果两个类的相同点过多，就要考虑提取超类。
### 3.19 不完美的库类（Incomplete Library Class）
* 如果只想修改库类中的一两个函数，可以运用“引用外加函数”的做法；如果想要添加一大堆行为，就得运用“引入本地扩展”的方法。
### 3.20 纯稚的数据类（Data Class）
* 指一些只提供数据访问的类（目前MVC架构中的JavaBean大都是这样），可以将更多的相关调用行为搬到这个类当中。
### 3.21 被拒绝的馈赠（Refused Bequest）
* 出现继承错误（子类不想使用父类的某些字段和函数）时，应该为子类建一个兄弟类，再运用“函数下移”及“字段下移”将所有用不到的函数推给那个兄弟。
### 3.22 过多的注释（Comments）
* 过多的注释是因为代码比较糟糕，应该首先尝试重构，让注释变得多余。
---
## 第4章 构筑测试体系
### 4.1 自测代码的价值
* 自测程序实际上可以提升编程速度，让程序员将注意力集中于接口而非实现。
### 4.2 JUnit测试框架
* 可以使用JUnit测试框架来编写单元测试，也可以辅助使用一些拥有GUI的测试工具。
### 4.3 添加更多测试
* 观察类应该做的事情，然后针对任何一项功能的任何一种可能失败情况，进行测试。
* 测试时应该覆盖到到边界值和中间值。
* 测试代码可以放心复制和编辑，进行某些条件的修改，以生成不同的测试用例。
---
## 第5章 重构列表
### 5.1 重构的记录格式
#### 重构手法的五个部分
* 名称：重构词汇表中重要的一部分。
* 概要：简单介绍此重构手法的适用情景，以及它所做的事情。
    * 第一部分：一句话，介绍这个重构能够帮助解决的问题。
    * 第二部分：一段简短陈述，介绍你应该做的事。
    * 第三部分：一幅速写图，简单展现重构前后示例，形式为代码或UML图。
* 动机：介绍为什么需要这个重构和什么情况下不该使用这个重构。
* 做法：简明扼要的介绍如何进行此重构。
* 范例：举例说明此重构手法如何运作。
### 5.2 寻找引用点
* 编译器太慢或无法通过反射机制找到引用点时，需要通过文本查找法来找出想找的东西。
### 5.3 这些重构手法有多成熟
* 必须考虑重构的手法是否适合自己当前的情况。
* 这些重构手法都是仅考虑单进程的前提，来设计的。
---
## 第6章 重新组织函数
### 6.1 Extract Method（提炼函数）
* 概要：将一段代码提取到独立函数当中，并让函数名称解释该函数的用途。
* 动机：
    * 提高函数复用性。
    * 降低覆写难度。
* 做法：创建函数，提炼代码，将局部变量作为参数进行传递，将被提炼的代码改为对函数的调用。
### 6.2 Inline Method（内联函数）
* 概要：当一个函数本体和名称同样清楚易懂时，在函数调用点插入本体，然后移除该函数。
* 动机：去除无用的间接调用。
* 做法：检查函数，确定它不具多态性（有子类继承的话就不要将此函数内联），找出函数的所有被调用点并将其替换为函数本体。
### 6.3 InLine Temp（内联临时变量）
* 概要：当临时变量只被简单表达式赋值一次时，将所有对该变量的引用动作替换为那个表达式自身。
* 动机：这个临时变量妨碍了其他重构手法（Replace Temp with Query）时，就应该将它内联化。
* 做法：检查等号右边表达式有无副作用，将临时变量赋值为final检查是否真的被赋值一次，替换临时变量的引用点为表达式。
### 6.4 Replace Temp with Query（以查询取代临时变量）
* 概要：当程序以一个临时变量存放某个表达式的运算结果时，将这个表达式提炼到独立函数当中。将这个临时变量的所有引用点转为对新函数的调用。此后，新函数就可以被其他函数使用。
* 动机：局部变量会使代码难以被提炼，所以应该尽可能把他们替换为查询式。
* 做法：找出只被复制一次的临时变量，将临时变量赋值为final检查是否真的被赋值一次，将赋值语句等号右边提炼到一个独立函数（先声明为private）当中，对该变量的引用实行内联。
### 6.5 Introduce Explaining Variable（引入解释性变量）
* 概要：将复杂表达式（或其中一部分）的结果放进一个临时变量，以此变量名称来解释表达式用途。
* 动机：在条件逻辑中，使用此法提炼条件子句。
* 做法：声明一个final临时变量，将待分解值复杂表达式的一部分动作的运算结果赋值给它，将表达式的“运算结果”部分替换为此临时变量。
### 6.6 Split Temporary Variable（分解临时变量）
* 概要：程序中有某个临时变量被赋值超过一次，它既不是循环变量，也不被用于收集计算结果时，针对每次赋值，创造一个独立、对应的临时变量。
* 动机：如果某个临时变量承担多个责任，它就应该被替换为多个临时变量，每个变量只承担一个责任。同一个临时变量承担两件不同的事情，会令代码阅读者糊涂。结果收集变量和循环变量不属于这种情况。
* 做法：
    1. 在待分解临时变量的声明及其第一次被赋值处，修改其名称；
    2. 将新的临时变量声明为final；
    3. 以该临时变量的第二次复制动作为界，修改此前对该临时变量的所有引用点，让他们引用新的临时变量；
    4. 在第二次赋值出，重新声明原先那个临时变量。
### 6.7 Remove Assignment to Parameters（移除对参数的赋值）
* 概要：代码对一个参数进行赋值(参数被改变而指向另一个对象)，以一个临时变量取代该参数的位置。
* 动机：这种形式混用了按值传递和按引用传递两种参数传递方式。而Java只采用值传递的方式，值传递的情况下，对参数的任何修改都不会对调用端造成影响。在Java中，不要对参数赋值。
* 做法：建立一个临时变量，将待处理的参数值赋予它，以“对参数的赋值”为界，将其后所有对此参数的引用点，全部替换为对此变量的引用。
#### Java的按值传递
* 在所有地点，Java都严格采用按值传递方式。
### 6.8 Replace Method with Method Object(以函数对象取代函数)
* 概要：大型函数中局部变量的使用使得无法采用Extract Method时，将这个函数放进一个单独对象中，局部变量就成了对象内的字段，然后就可以将这个大型函数分解为多个小型函数。
* 动机：函数中局部变量过多，分解函数困难时，使用此方法。
* 做法：
    1. 建立一个新类，根据待处理函数的用途，为这个类命名。
    2. 在新类中建立一个final字段，用以保存原来大型函数所在的对象。我们将这个字段称为“源对象”。同时，针对原函数的每个临时变量和每个参数，在新类中建立一个字段保存。
    3. 在新类中建立一个构造函数，接收源对象及原函数的所有参数作为参数。
    4. 在新类中建立一个compute()函数，将原函数中的代码复制到compute()函数当中。如果需要调用源对象的任何函数，通过源对象字段调用。
    5. 将旧函数的本体替换为：创建上述新类的一个新对象，然后调用其中的compute()函数。
### 6.9 Substitute Algorithm（替换算法）
* 概要：将函数本体替换为另一个更清晰或更简便的算法，对新旧算法均进行测试，观察两者的结果是否相同。
---
## 第7章 在对象之间搬移特性
### 7.1 Move Method（搬移函数）
* 概要：程序中有个函数与其所驻类之外的另一个类进行更多交流：调用后者或者被后者调用；在该函数最常引用的类中建立一个有着类似行为的新函数。将旧函数变成一个单纯的委托函数，或者将旧函数完全移除。
* 动机：如果一个类有太多行为，或如果一个类与另一个类有太多合作而形成高度耦合，就使用搬移函数。
* 做法：
    1. 检查源类中被源函数所使用的的一切特性（包括字段和函数），考虑他们是否也应该被搬移。
    2. 检查源类的子类和超类看看是否有该函数的其他声明。
    3. 在目标类中声明这个函数，将源函数的代码复制到目标函数中，决定如何从源函数正确引用目标对象（使用现成字段或者需要新建字段到源类中）
    4. 修改源函数，使之成为纯委托函数；决定是否删除源函数，或者将它作为委托函数保留（如果经常要在源对象中引用目标函数，那么将源函数作为委托保留下来会比较简单）。
### 7.2 Move Field（搬移字段）
* 概要：程序中某个字段被其所驻类之外的另一个类更多的用到。在目标类新建一个字段，修改原字段的所有用户，令它们改用新字段。
* 做法：如果字段的访问级是public，将它封装起来。在目标类中建立与源字段相同的字段，并同时建立相应的设值取值函数。在源对象中引用目标对象，删除源字段，把所有对源字段的引用替换为对某个目标函数的调用。
### 7.3 Extract Class（提炼类）
* 概要：某个类做了应该由两个类做的事情，那么就建立一个新类，将相关的字段和函数从旧类搬移到新类。
* 动机：对复杂类进行责任分离。
* 做法：决定应该如何分离类的责任，建立新类用以表现从旧类分离出来的责任。建立从旧类访问新类的连接关系，搬移字段和方法，精简每个类的接口，决定是否公开新类。
### 7.4 Inline Class（将类内联化）
* 概要：某个类没有做太多事情，将这个类的所有特性搬移到另一个类中，然后移除原类。
* 动机：如果某个类不再承担足够责任、不再有单独存在的理由，就将这个类塞进另一个类中。
* 做法：在目标类身上声明源类的public协议，并将其中所有函数委托至源类；修改所有源类引用点，改而引用目标类；将源类的特性全部搬移到目标类。
### 7.5 Hide Delegate（隐藏委托关系）
* 概要：客户通过一个委托类来调用另一个对象。在服务类上建立客户所需的所有函数，用以隐藏委托关系。
* 动机：隐藏委托关系，即便将来委托关系发生变化，变化也将限制在服务对象中，不会波及客户。
* 做法：对于每一个委托关系中的函数，在服务端建立一个简单的委托函数。调整客户，令它只调用服务对象提供的函数。
### 7.6 Remove Middle Man（移除中间人）
* 概要：某个类做了过多的简单委托动作，让客户直接调用受托类。
* 动机：每当客户要使用受托类的新特性时，你就必须在服务端添加一个简单委托函数。随着受托类的特性越来越多，服务类完全变成了一个中间人，此时就应该让客户直接调用受托类。重构就是在系统运行过程中使用Hide Delegate和Remove Middle Man之间来回调整。
* 做法：建立一个函数，用以获得受托对象；对于每个委托函数，在服务类中删除，并让客户转为调用受托对象。
### 7.7 Introduce Foreign Method（引入外加函数）
* 概要：你需要为提供服务的类增加一个函数，但你无法修改这个类时，就在客户类中建立一个函数，并以第一参数形式传入一个服务类实例。
* 动机：需要类提供新功能时，可以在客户端添加外加函数。如果许多类都存在同样的问题，就应该使用Introduce Local Extension方法重构。
* 做法：在客户类中建立一个函数，用来提供需要的功能。以服务类实例作为该函数的第一个参数。
### 7.8 Introduce Local Extension（引入本地扩展）
* 概要：你需要为服务类提供一些额外函数，但你无法修改这个类。建立一个新类，使它包含这些额外函数。让这个扩展成为源类的子类或包装类。
* 动机：本地扩展是一个独立的类，但也是被扩展类的子类型，它提供源类的一切特性，同时添加额外新特性。在任何使用源类的地方，你都可以使用本地扩展取而代之。
* 做法：建立一个扩展类，将它作为原始类的子类或包装类；在扩展类中加入转型构造函数；在扩展类中加入新特性，根据需要，将源对象替换为扩展对象；将针对原始类定义的所有外加函数搬移到扩展类中。
---
## 第8章 重新组织数据
### 8.1 Self Encapsulate Field（自封装字段）
* 概要：字段之间的耦合关系变得笨拙时，为这个字段建立取值/设值函数，并且只以这些函数来访问字段。
* 动机：可以先采用直接访问变量的方式进行访问，直到这种方式带来麻烦，改为使用简介访问的方式。
* 做法：为待封装字段建立取值/设值函数；找出字段的所有引用点，全部改为调用取值/设值函数；将字段声明为private，复查，确保找出了所有的引用点；编译测试。
### 8.2 Replace Data Value with Object（以对象取代数据值）
* 概要：当有一个数据项需要与其他数据和行为一起使用才有意义时，将数据项变成对象。
* 动机：函数声明中的参数越来越多，并且它们都有一定的联系时，就需要将这些数据值变为对象。
* 做法：为待替换数值新建一个类，在其中声明一个final字段，其类型和源类中的待替换数值类型一样。然后在新类中取值函数和构造函数，将函数中的字段改为新建的类。
### 8.3 Change Value to Reference（将值对象改为引用对象）
* 概要：一个类衍生出许多彼此相等的实例，希望将它们替换为同一个对象，就将这个值对象变成引用对象。
* 动机：从值对象开始，希望给对象加入一些可修改数据并确保对任何一个对象的修改都能影响到所有引用此一对象的地方，这时候就需要将这个对象变为一个引用对象。
* 做法：
    1. 使用Replace Constructor with Factory Method（以工厂函数取代构造函数）
    2. 决定由什么对象负责提供访问新对象的途径。可能是一个静态字典或者一个注册表对象，也可以使用多个对象作为新对象的访问点。
    3. 决定这些引用对象应该预先创建好，或是应该动态创建。如果这些引用对象是预先创建好的，而你必须从内存中将它们读取出来，那么就得确保它们在被需要的时候能够及时加载。
    4. 修改工厂函数，令他们返回引用对象。如果对象是预先创建好的，你就需要考虑：万一有人索求一个其实并不存在的对象，你要如何处理错误；需要修改工厂函数的名称，使其传达这样的信息：他返回的是一个即存对象。
### 8.4 Change Reference to Value（将引用对象改为值对象）
* 概要：你有一个引用对象，很小且不可变，而且不易管理，就将它变为一个值对象。
* 动机：引用对象变得难以使用时，就应该将它改为值对象；值对象的重要特性：应该是不可变的。
* 做法：
    1. 检查重构目标是否为不可变对象，或是否可修改为不可变对象。如果该对象目前不是不可变的，就使用Remove Setting Method，直到它成为不可变的为止。如果无妨将该对象设置不可变的，就放弃使用本项重构。
    2. 编译测试，考虑是否可以删除工厂函数，并将构造函数声明为public.
### 8.5 Replace Array with Object（以对象取代数组）
* 概要：你有一个数组，其中的元素各自代表不同的东西。以对象替换数组，对于数组中的每个元素，以一个字段来表示。
### 8.6 Duplicate Observed Data（复制“被监视数据”）
* 概要：你有一些领域数据置身于GUI控件中，而领域函数需要访问这些数据。将该数据复制到一个领域对象当中。建立一个Observer模式，用以同步领域对象和GUI对象内的重复数据。
* 动机：一个分层良好的系统，应该将处理用户界面和处理业务逻辑的代码分开。如果代码是两层开发，业务逻辑被内嵌于用户界面之中，就有必要将其分离出来，其中的数据就需要复制到新的对象中，并提供相应的同步机制。
### 8.7 Change Unidirectional Association to Bidirectional（将单向关联改为双向关联）
* 概要：两个类都需要使用对方特性，但其间只有一条单向连接，则添加一个反向指针，并使修改函数能够同时更新两条连接。
* 动机：单向连接不足以满足两个类之间互相操作时，就需要建立双向引用关系。
* 做法：
    1. 在被引用类中增加一个字段，用以保存反向指针。
    2. 决定由哪个类（引用端还是被引用端）控制关联关系。
        1. 如果两者都是引用对象，而其间的关联是“一对多”关系，那么就由“拥有单一引用”的那一方承担“控制者”角色。如果一个客户可以拥有多份订单，那么就由Order来控制关联关系。
        2. 如果某个对象是组成另一个对象的部件，那么由后者负责控制关联关系。
        3. 如果两者都是引用对象，而其间的关联是“多对多”的关系，那么随便其中哪个对象来控制都无所谓。
    3. 在被控端建立一个辅助函数，其命名应该清楚之处它的有限用途。
    4. 如果既有的修改函数在控制端，让他负责更新反向指针。
    5. 如果既有的修改函数在被控端，就在控制端建立一个控制函数，并让既有的修改函数调用这个新建的控制函数。
### 8.8 将双向关联改为单向关联（Change Bidirectional Association to Unidirectional）
* 概要：两个类之间有双向关联，但其中一个类如今不再需要另一个类的特性。
* 动机：如果发现双向关联不在有存在价值，就应该去掉其中不必要的一条关联。
* 做法：
    1. 找出保存“你想去除的指针”的字段，检查它的每一个用户，判断是否可以去除该指针。
    2. 如果客户使用了取值函数，先运用“自封装字段”将待删除字段自我封装起来，然后使用“替换算法”，使得取值函数不再使用该字段。
    3. 如果客户未使用取值函数，那就直接修改待删除字段的所有被引用点：改以其他途径获得该字段所保存的对象。
    4. 如果已经没有任何函数使用待删除字段，移除所有对该字段的更新逻辑，然后移除该字段。
### 8.9 以字面常量代替魔法值
* 做法：有特别含义的字面数值，需要创建一个常量，并根据其意义为它命名，并将上述的字面数值替换为这个常量。