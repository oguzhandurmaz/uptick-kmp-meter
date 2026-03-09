# UpTick

![Kotlin](https://img.shields.io/badge/Kotlin-Multiplatform-blue)
![Compose](https://img.shields.io/badge/Compose-Multiplatform-green)
![Platform](https://img.shields.io/badge/platform-android%20%7C%20ios-lightgrey)
![License](https://img.shields.io/badge/license-MIT-orange)

UpTick is a modern **meter application** built with **Kotlin Multiplatform (KMP)** and **Compose Multiplatform (CMP)**.

The project demonstrates a **modular architecture**, **shared business logic**, and **cross-platform UI development** using modern Kotlin technologies.

---

# 📱 Screenshots

### Light Theme
![Light Screenshot](docs/images/ss1_light.png)

### Dark Theme
![Dark Screenshot](docs/images/ss2_dark.png)

---

# Features

- Increment meter value
- Reset meter
- Smooth Compose Multiplatform UI
- Light / Dark theme support
- Modular architecture
- Shared business logic across platforms

---

# 🏗 Architecture

The project follows a **modular clean architecture** approach.

```

shared
├── components
├── navigation
├── designsystem
├── domain
feature
├── home
├── meter
│ ├── domain
│ └── presentation


```

Architecture layers:

- **Presentation** → UI and state management
- **Design System** → reusable UI components
- **Navigation** → shared navigation structure

---

# 🧰 Tech Stack

- Kotlin Multiplatform
- Compose Multiplatform
- Kotlin Coroutines
- Gradle Kotlin DSL
- Modular Architecture
- Material3 Design

---

# 📦 Project Structure

```

UpTick
├── androidApp
├── iosApp
├── shared
│ ├── designsystem
│ ├── components
│ ├── system
├── navigation
├── feature
│ ├── home
│ └── meter

```

---

# Getting Started

### Requirements

- Android Studio (latest)
- Kotlin Multiplatform plugin
- Xcode (for iOS build)

### Clone the repository


Clone the repository:

```
git clone https://github.com/oguzhandurmaz/uptick-kmp-meter.git
```

Open with **Android Studio (KMP supported version)**.

Run:

```
androidApp
```

or

```
iosApp
```

# 📄 License

This project is licensed under the **MIT License**.