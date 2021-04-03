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
- Afters successful creation doctor is notified via email

#### First requirements change

TBD


### Patient requirements

- During creation process, the system force client to provide patient's ID number. It is needed to 
  check patient`s insurance existence and illness history
- Afters successful creation patient is notified via SMS

#### First requirements change

TBD

### Visit requirements

- `doctor`, and `patient` entities must be present
- Both entities have to had free visit slot at the same day
- Visit with date > 14 days ahead cannot be created

## What is inside

There are many branches in this project:

- `master` - shows the project final version
- `service-initial` - shows `service` approach with initial requirements
- `service-first-chage` - shows `service` approach after first requirements change
- `ddd-initial` - shows `ddd` approach with initial requirements
- `ddd-first-chage` - shows `ddd` approach after first requirements change

