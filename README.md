# MakeMeFit
A console based app to track a user's daily calorie intake and help him to achieve his goal.



Download the code as zip and extract.
Place the folder "Fit" in your D drive(If u don't have d drive place the folder anywhere u like and change the path name in the code to the respective).


All Java files(code) are inside src folder


**AIM:**
To create a console based application to calculate some specific amount of
calories according to the user's wish(Gain weight,Loss weight,Maintain weight) and
keep track of their daily calorie intake and maintain their data to help them achieve
their goal.


**RESOURCES:**


Language used:Java
Ide used: IntellJi Idea(Jet brains)


**CORE FEATURES:**


● Account creation


● Calculate target calories


● Tracking user’s daily calorie intake


● Showing user’s reports


● Food and workout recommendation system


● Checking user’s process weekly


● Checking if user achieved their goal


**FEATURE IN DETAIL:**


**Account Creation:**
1. User’s can create an infinite number of multiple accounts.
2. Once a user creates an account their login credentials will be
saved in our data.
3. Users can login only using valid credentials.
4. A prompt will be popped when the program is gonna end to get
the choice of the user if we want to log out or want to stay
logged in. If users wish to stay logged in a log status will be
updated and next time the program runs that user will stay
logged in else the user will be logged out and on next time the
program runs he needs to provide his login credentials to get
logged in again.


**Calculate target calories:**
1. Once a user is given their data(weight,height,age,gender,activity
level,their goal) we will use Mifflin-St Jeor Equation for
calculating the user's daily target calorie.
Tracking user’s daily calorie intake:
1. A dashboard will be displayed with options to save the user's
calories intake(Breakfast,lunch,dinner,Snacks and others).
2. Users can input their food names,we will calculate it’s calories
and save in a data file(if user’s input food which is not in our
data file a new prompt will be given and we will save their
food(Explained in food and workout recommendation
system feature).
3. Will check if the user's daily intake of calories satisfied our target
calories.
4. All data user’s given will be saved in our data file for future use.


**Showing user’s report:**
1. Users can see their data reports on how much calories they
took in the previous period of time.
2. Two options are given
a. A specific day report:
Users can choose any day,and we will show how
many calories he took on that day, breaking the data into
how many calories he consumed on
breakfast,lunch,dinner and snacks and other and his total
calories on that day.
b. Full report:
In this option users full data(from the day 1) will be
shown in a format of (“Day x : xxxx calories).


**Settings:**
1. Provide users to edit their personal details like name,activity
level.
2. Log out feature.


**Food and workout recommendation system:**


● Food recommendation:
1. If a user missed his diet plan and now he is lagging
behind his target calories,our program would recommend
foods to achieve their target calorie goal.
2. We will be using a little algorithm to recommend a food


● If for example a user needs extra 450
calories to fulfill his target calorie goal,we
will import data from our food data file and
traverse through all food calorie details and
return a food whose calorie is near best to
450.
3. If a user is lagging behind his target calorie goal and he
wants to need his own food, we will provide all our data of
food and he can choose what to eat,and we will calculate
how many quantities of that food needs to eat.
4. If a user doesn’t like any food in our food data file,a
prompt will be displayed asking the user's food and it’s
calorie details which will be saved in our data file and will
be used when the user wants to eat it next time.


**Workout recommendation system:**
1. Same as food recommendation system,if a user
had ate extra calories program will recommend
some workouts,also if user doesn’t like we will
display all workouts available and calculate how
many reps he need do,also if he doesn’t like
workout from above we will ask about his workout
detail and store it’s information in our data file and
use in future use.


**Checking user’s daily process:**
Checking the user's process weekly once to see if the user is
moving towards his goal flawlessly.


Checking if user achieved his goal:
Once his target days are over,checking if the user has
completed his goal or not.


● If the user completed his goal we will change his target calorie
and recreate his plan to now maintain his current weight.


● If the user is unable to complete his goal,we will get his current
weight and recreate his plan to achieve his goal.
