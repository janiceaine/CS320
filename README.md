# CS320
**README**

**How can I ensure that my code, program, or software is functional and secure?**
To make sure my code works correctly and is safe to use, I rely on testing and checking inputs carefully. For example, in the Contact and Task classes, I wrote tests to make sure each field, like firstName and description, follows specific rules, such as length limits or formats. A test like testFirstNameCannotBeNull ensures that an empty value can’t be entered, keeping the program reliable. For security, I added checks in the Appointment class to prevent setting dates in the past. Using exceptions helps my code catch mistakes right away, so users get feedback when something isn’t allowed. Altogether, testing and input checks make sure my code works well and keeps data safe from errors.

**How do I interpret user needs and incorporate them into a program?**
Understanding what users need starts with looking at the requirements and turning them into code checks. In the Contact class, for instance, the requirement for a unique, 10-character contact ID led me to add checks in the code that only allow valid IDs. I did something similar for phone numbers by setting a rule that they must be exactly 10 digits. I also used this approach in the Appointment class to make sure that appointments couldn’t be set in the past. Each rule I added in the code helped make sure the program matched what users wanted and expected. By directly linking user needs to the code, I can create a program that behaves just as they expect.

**How do I approach designing software?**
When designing software, I like to break the project into smaller parts to focus on each section separately. For example, I made the Contact class for user information, the Task class to track tasks, and the Appointment class to manage test dates. Each part had a specific purpose, making it easy to focus on one area at a time. I also find that drawing diagrams helps me plan how each part connects with the others. For example, I made diagrams to see how booking an appointment with an instructor would work. By keeping the design simple and organized, I make the program easier to build and test, and it’s also easier to improve later on.

