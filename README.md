# DevSoc App Development Project Report
**PROJECT NAME: Book Sharing App(DigiShare)**
**LANGUAGE USED FOR CODING**: Java
**ABOUT DIGISHARE:**
Digishare has the following features:
● Signin/Signup option using email+password or by using Google Sign
In(Using firebase authentication).
● Add a book feature-(User is expected to enter the book
description(Book Name,Author,Number of Pages,Genre,Description).
● Speech to Text Conversion is made available for entering the Book
Description so that the user does not have to go through the
cumbersome process of typing the entire book description).
● E-book in pdf format can be added(Browse from the internal storage
of your device and upload the same.Cancel option also available if
the wrong pdf is uploaded).
● PDF uploaded by the user is stored in Firebase Cloud Storage and its
URL is saved along with the book details in the Firestore.
● Visit Store Option-All the books uploaded by the authorized users of
the app are displayed together in a Recycler view.
● Sorting Option is made available to sort the books in order of :
1.Ascending order of book title
2.Descending order of book title
3.Academic Genre
4.Non Academic Genre
● On clicking a particular book, the entire book details are displayed in
another activity.
● On clicking the pdf icon a downloadable pdf version of the E-book is
stored in your device

**WHAT WE LEARNT IN THIS PROJECT:**
Through this project we learnt to make use of Firebase/Firestore and
Recycler View. We incorporated a Google Sign-In option which used
Firebase Authentication. There is an option of Signing In/Signing Up via
email+password as well which is connected to the same database where
we can monitor the users of the app.
Adding Books is implemented using Firebase Firestore.We learnt to add
some interesting features like the Speech to Text Conversion and adding
the E-book in PDF format, using Firestore and Firebase Cloud Storage.
We learnt how to sort items in Recycler view using the amazing querying
style of the Firestore.
We made optimal use of what was expected of us (Firebase and Recycler
view) and added the Google Sign-In,Speech to Text Conversion pdf
download options too.
We learnt a lot in the past 2 weeks through debugging, browsing loads of
online resources and helping each other sort out errors, and indeed it was
an enriching experience .

**CONTRIBUTIONS**:
Lavkush Sharma: Created dynamic list using the recycler view for the
application. Designed the interface used in the application.
Niharika Sathish: As an alternative to Sign In using email+password,
implemented the direct Google Sign in feature using Firebase
Authentication, with a Google API Console Project. Ideated App names.
Sumedha Panja: Implemented the Sign In/Sign Up Option using
email+password using Firebase authentication.Also implemented the
adding book feature,Speech to Text Conversion and
uploading/downloading E-book in PDF Format.Contributed towards the UI
as well
**Go through the Android Studio Project In Master Branch to know more.**
