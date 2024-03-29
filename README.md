
# **Android Projects - 5 semester**
- [General requirements](#general-requirements)
- [Lab 1](#1-americans-are-asleep-upvote-the-metric-system)
- [Lab 2](#2-nobody-runs-in-your-family)
- [Lab 3](#3-you-wanna-play-lets-play)
- [Demo gifs](#examples-of-working)

---
## General requirements

Every application should be 'equipped' with **basic versioning** implementation. Resulting application package should have proper `versionCode` and `versionName` (make sure to find out what are the differences between these values) according to SEMVER (Semantic Versioning). Version name should contain major, minor and patch version numbers. A version tracking should be performed by utilizing git tag feature. Each tag should be formatted as `MAJOR.MINOR` (e.g. 1.3), PATCH number represents a number of commits performed after latest release (latest tag) (all numbers are obtained via git shell commands).


## 1. 'Americans are asleep. Upvote the metric system!'
A 'Unit/Currency Converter' application.

1. Minumum 3 different unit categories (distance, weight, currency, etc)
2. At least 3 different units in each category.
3. Calculator-like num pad and two fields for original and converted values. The user should not be able to change data in these fields with default system keyboard.
4. A keyboard and data should be in separate android fragments.
   - portrait orientation: fragments are placed in a row (keyboard below data fragment)
   - landscape orientation: fragments have to be aligned in line.
5. Create a 'premium' build flavour.
   - There should be a button, that will switch initial and converted values (and units) and vice-versa.
   - A button to copy current value to the clipboard near each data field.
   - Use source sets to define different layouts and files with code for each flavour.
6. Release notes:
   - **Copying**:  Long click on the text u want to copy.
   - **Switching values & units**: Premium version doesn't contain a button for the swithing. This feature is implemented by making values' textviews clickable (cuz I think it's more user-friendly).
  

## 2. 'Nobody runs in your family...'
A 'Tabata timer' application.

1. A user can create different timer sequences and switch between them (use GSON or SQLite for data storage).
2. Home page - a list of sequences
   - CRUD for them
3. Sequence properties:
   - title
   - colour
4. Timer page:
   - remaining time of the current phase
   - list of upcoming phases
   - controls to pause, go back and forth through the sequence or to leave this page and cancel the timer
5. Edit page:
   - tweak duration of each phase (workout, rest, warm-up, cooldown)
   - change number of phase repetitions and rest periods between them
   - define sequence properties
6. While running, each phase switch should trigger a sound to warn user.
7. The timer should not stop when user leaves the app (see Services).
8. Settings page (implemented with AndroidX Preference library):
   - day / night theme
   - change app font size (without app reload)
   - a button to clear all stored data
   - switch app locale (a choice between two languages at least).
9. Application should have a splash screen with app name or artwork to entertain the user while the app is being loaded.


## 3. 'You wanna play? Let's play!'
Online  'Battleship' or 'Chess' game.

1. Two players should be able to participate in the game from different devices.
2. Firebase Firestore / RealtimeDB or similar service as a back-end.
3. Authentication using any auth provider (Google, social network, etc) or plain email-password pair.
4. User 1 creates a game and shares generated game ID with opponent.
5. Opponent (user 2) joins the game via given ID.
6. User 1 device acts as a server and is responsible for game state updates.
7. User 2 device subscribes to state changes in DB and updates interface.
8. User statistics page with previous games
9. User profile page:
    - nickname change
    - avatar (user can switch between these two options in profile)
      - remote storage using Firebase File storage
      - [Gravatar](https://ru.gravatar.com/)

## Examples of working
<p align="center"><b>Converter | Tabata timer | Battleship</b></p>  
<p align="center">
  <img src="https://user-images.githubusercontent.com/61284371/128781980-3dc64efa-4305-44ce-aabb-cb680eec729f.gif" height="30%" width="30%">
  <img src="https://user-images.githubusercontent.com/61284371/128781974-13ad83bd-8d0c-42ee-9c04-7795e163cef1.gif" height="30%" width="30%">
  <img src="https://user-images.githubusercontent.com/61284371/128780820-bb046f02-6736-4a7c-af72-e89672d6c729.gif" height="30%" width="30%">
</p>
