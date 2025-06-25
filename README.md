# 📞 QuickReach (Prototype) ☎️

QuickReach is a Java-based Android prototype app that displays categorized contact lists using an ExpandableListView structure. Each category reveals a grid of contacts, each with an image and a phone number. Designed for simplicity and easy extension, this app enables one-tap dialing directly from each contact tile.

---

## 📱 Features

- Categorized contacts (e.g. Hospitals, Restaurants, Stores)  
- Grid-based contact layout using GridLayout and CardView  
- Custom-styled category headers with rounded corners and color backgrounds  
- Tap-to-dial functionality using Android's phone dialer  
- Simple UI customizations using resource files  
- Easy-to-modify categories and contact data in Java  

---

## 🛠 Technologies Used

- Android SDK  
- Java  
- ExpandableListView  
- GridLayout  
- CardView  
- Vector Drawable Icons  

---

## ☕ Java Note: Language Legacy and Transition to Kotlin

QuickReach is built using **Java**, which was Android’s primary language until 2017. In that year, **Google officially announced Kotlin as a first-class language** for Android development at Google I/O. Kotlin brings modern language features like null safety, extension functions, and cleaner syntax that reduce boilerplate and improve developer productivity.

While Java is still fully supported and used in many legacy and enterprise apps, most modern Android projects have adopted Kotlin for its expressiveness and tooling support.

This project remains Java-based for simplicity, educational clarity and an insight into the past, but migrating to Kotlin would be a natural evolution for contributors or forked versions.

---

## 📂 Folder Structure

```
app/  
├── java/com/mnk/quickreach/        ← MainActivity & CustomExpandableListAdapter  
├── res/  
│   ├── layout/  
│   │   ├── activity_main.xml        ← Root UI with ExpandableListView  
│   │   ├── group_item.xml           ← Category headers with background styling  
│   │   └── child_item.xml           ← Contact grid tile with image & text  
│   ├── drawable/  
│   │   ├── ic_launcher_foreground.xml   ← White phone icon (customizable)  
│   │   └── group_background.xml       ← Header shape background  
│   └── values/colors.xml            ← App color palette  
```

---

## 🧪 How to Customize

### 👤 Add or Edit Categories & Contacts

Open `MainActivity.java` and edit the `populateContacts()` method. You can easily change or add new categories and contact entries. Make sure to provide the relevant contact images in `res/drawable/`.

```java
contactsList.put("Emergency Services", Arrays.asList(
    createContact("Fire Department", "101", R.drawable.fire_icon),
    createContact("Police", "100", R.drawable.police_icon)
));
```

### 🖼️ Replace Icon

To change the app icon, replace `ic_launcher_foreground.xml` with a custom vector drawable (now a white telephone icon). No need to modify build files. The background is Android's regular green background defined in the `ic_launcher_background.xml`.

### 🎨 Color and Styling

Adjust colors in `res/values/colors.xml`. You can also change the background of group headers via `group_background.xml`.

---

## 🚀 How to Run

1. Clone the repo  
2. Open in Android Studio  
3. Sync Gradle  
4. Build and run on a physical device or emulator (API 21+ recommended)  

---

## 📜 License

This is an open-source prototype for demonstration and educational use. Feel free to fork, expand, or customize as needed.
