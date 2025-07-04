~~~java
# ☕ Java 代码重构示例：Person 与 Room

## 项目简介

本项目是一个简单的 Java 应用，旨在演示基础的面向对象设计，并重点展示一项关键的代码重构技巧——**提取私有辅助方法 (Extract Private Helper Method)**。

项目定义了 `Person` (人) 类和 `Room` (房间) 类。`Room` 类的核心功能是维护一个人员列表，并提供方法来查找、获取房间内身高最矮的人。

---

## ✨ 设计重点：私有辅助方法的使用

本项目设计的一个核心亮点，就是通过使用私有辅助方法来避免代码重复。

最初，在 `shortest()` 和 `take()` 这两个不同的公开方法中，都存在着一段完全相同的逻辑——“查找身高最矮的人”。

为了解决这个问题，我们将这段通用的查找逻辑提取到了一个**私有的辅助方法 `findShortestPerson()`** 中。这种做法带来了三大好处：
1.  **遵守 DRY 原则 (Don't Repeat Yourself)**: 查找逻辑只编写了一次，消除了冗余。
2.  **提高可维护性**: 当需要更新查找逻辑时，只需在一个地方修改即可。
3.  **增强代码可读性**: 公开方法的职责变得更加单一和清晰。

---

## 🚀 如何使用

### 环境要求
* Java Development Kit (JDK) 8 或更高版本。

### 运行步骤
1.  将项目中的两个核心类分别保存为 `Person.java` 和 `Room.java` 文件。
2.  创建一个 `Main.java` 文件（如下方示例代码所示），并与前两个文件放在同一个文件夹下。
3.  打开命令行工具 (如 Terminal 或 Git Bash)，进入存放这三个文件的文件夹。
4.  编译所有 Java 文件：
    ```bash
    javac *.java
    ```
5.  运行主程序：
    ```bash
    java Main
    ```
    你将会在控制台看到程序的输出结果。

### 示例代码 (`Main.java`)
新的主程序通过一个 `while` 循环，不断从房间中取出并打印身高最矮的人，直到房间变为空。这会产生一个有趣的效果：所有人的信息会按照身高从低到高的顺序被依次打印出来。

```java
public class Main {

    public static void main(String[] args) {
        // 1. 创建一个新的房间
        Room room = new Room();

        // 2. 添加一些人到房间
        room.add(new Person("Lea", 183));
        room.add(new Person("Kenya", 182));
        room.add(new Person("Auli", 186));
        room.add(new Person("Nina", 172));
        room.add(new Person("Terhi", 185));

        System.out.println("按身高从低到高依次取出房间里的人：");
        
        // 3. 循环取出最矮的人，直到房间为空
        while (!room.isEmpty()) {
            System.out.println(room.take());
        }
    }
}
```

### 预期输出
运行上面的主程序，你会在控制台看到以下输出：

```
按身高从低到高依次取出房间里的人：
Nina (172 cm)
Kenya (182 cm)
Lea (183 cm)
Terhi (185 cm)
Auli (186 cm)
```

---

## 核心类说明

* **`Person.java`**: 代表一个人的数据类，包含 `name` (姓名) 和 `height` (身高) 属性。
* **`Room.java`**: 代表一个包含多个 `Person` 对象的房间。

---

## 🛠️ 未来的改进方向 (To-Do List)

* [ ] **使用 Stream API**: 将 `findShortestPerson()` 方法用 Java 8 的 Stream API 重构，使代码更简洁。
* [ ] **实现 `hashCode()`**: 在 `Person.java` 中，根据 `equals()` 的约定，对应实现 `hashCode()` 方法。
* [ ] **增加单元测试**: 使用 JUnit 等测试框架为 `Room` 类中的方法编写单元测试，确保其健壮性。
* [ ] **处理身高相同的情况**: 明确当有多个身高最矮的人时，`shortest()` 和 `take()` 方法的行为（例如，总是返回第一个找到的，或根据其他
~~~