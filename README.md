# Hexagonal + DDD example

## Overview

This project has been created to internal presentation at [ZEN](http://zen.com) company purpose. It shows 
differences between old-fashioned "service" approach and modern hexagonal and DDD way. 

### What problem it resolves?

This is a well known problem, when someone has to book an appointment with a doctor. So we have several domain 
entities here:

- `doctor` - with possibility to add, getAll, get one
- `patient` - same as doctor
- `visit` - it connects `doctor` with `patient` at some concrete hour

### Doctor requirements

#### Initial requirements

- During creation process, the system force client to provide doctor's practise license number. It is needed to check  
  doctor's right to practise his profession in other system, and get his specialization among other parameters
- After successful creation doctor is notified via email

#### Requirements change

- There is huge API license number change (in progress)
- After successful creation doctor is notified via push notification (in progress) 

### Patient requirements

#### Initial requirements

- During creation process, the system force client to provide patient's ID number. It is needed to 
  check patient`s insurance existence and illness history
- There are much insurance level's. Patients who's are below MEDIUM level, cannot be added

#### Requirements change

- There are different insurance types / for different world regions

### Visit requirements

- `Doctor`, and `Patient` entities must be present
- Both entities have to had free visit slot at the same day
- Visit with date > 14 days ahead cannot be created
- `Doctor` is notified via email 
- `Patient` is notified via SMS

#### Requirements change

## What is inside

There are many branches in this project:

- `master` - shows the project current version
- `service-initial` - shows `service` approach with initial requirements (in progress)
- `service-first-chage` - shows `service` approach after first requirements change (in progress)
- `ddd-initial` - shows `ddd` approach with initial requirements 
- `ddd-first-chage` - shows `ddd` approach after first requirements change (in progress)

