
# YouQuiz

YouQuiz is a learning platform to help students pass quizzes easily, provided by their trainers.


## API Documentaion

#### Get all subjects

```
  GET /api/subjects
```

**Response**
```json
    "subjects": [
        {
            "id": 1,
            "title": "sub1",
            "parent": null,
            "children": [
                {
                    "id": 3,
                    "title": "sub2",
                    "parentId": 1
                }
            ]
        },
        {
            "id": 3,
            "title": "sub2",
            "parent": {
                "id": 1,
                "title": "sub1",
                "parent": null,
                "children": [
                    {
                        "id": 3,
                        "title": "sub2",
                        "parentId": 1
                    }
                ]
            },
            "children": []
        }
    ]
```

#### Get one subject

```
  GET /api/subjects/${id}
```

Note that the subject id is **Required**

**Response**
```json
"subject": {
        "id": 1,
        "title": "sub1",
        "parent": null,
        "children": [
            {
                "id": 3,
                "title": "sub2",
                "parentId": 1
            }
        ]
    }
```

#### Create subject

```
  POST /api/subjects
```
Note that the subject id is **Required** except the *parentID*

**Payload**
```json
{
    "id": 2,
    "title": "sub2",
    "parentId": 1 // or null if the created subject has no parent
}
```

**Response**
```json
{
    "subject": {
        "id": 4,
        "title": "sub2",
        "parent": {
            "id": 1,
            "title": "sub1",
            "parent": null,
            "children": [
                {
                    "id": 3,
                    "title": "sub2",
                    "parentId": 1
                },
                {
                    "id": 4,
                    "title": "sub2",
                    "parentId": 1
                }
            ]
        },
        "children": null
    },
    "message": "subject created"
}
```

#### Update subject

```
  PUT /api/subjects/${id}
```

Note that the subject id is **Required** except the *parentID*

**Payload**
```json
{
    "id": 2,
    "title": "sub2",
    "parentId": 1 // or null if the updated subject has no parent
}
```

**Response**
```json
{
    "subject": {
        "id": 4,
        "title": "sub2",
        "parent": {
            "id": 1,
            "title": "sub1",
            "parent": null,
            "children": [
                {
                    "id": 3,
                    "title": "sub2",
                    "parentId": 1
                },
                {
                    "id": 4,
                    "title": "sub2",
                    "parentId": 1
                }
            ]
        },
        "children": null
    },
    "message": "subject updated"
}
```

#### Delete subject

```
  DELETE /api/subjects/${id}
```
Note that the subject id is **Required**

**Response**
```
Subject with ID ${id} has been deleted.
```

#### Get all students

```
  GET /api/students
```

**Response**
```json
    {
    "students": [
        {
            "firstname": "Said",
            "lastname": "Dali",
            "birthdate": "2003-04-12",
            "address": "This is a said address",
            "id": 1,
            "registeredAt": "2023-04-01",
            "quizzes": []
        },
        {
            "firstname": "Kamal",
            "lastname": "Ahmed",
            "birthdate": "2003-04-12",
            "address": "This is a kamal address",
            "id": 2,
            "registeredAt": "2023-04-01",
            "quizzes": []
        }
    ],
    "message": "students found"
}
```

#### Get one student

```
  GET /api/students/${id}
```

Note that the student id is **Required**

**Response**
```json
{
    "student": {
        "firstname": "Said",
        "lastname": "Dali",
        "birthdate": "2003-04-12",
        "address": "This is a said address",
        "id": 1,
        "registeredAt": "2023-04-01",
        "quizzes": []
    }
}
```

#### Create student

```
  POST /api/subjects
```
Note that all fields are **Required**

**Payload**
```json
{
    "firstname": "Kamal",
    "lastname": "Ahmed",
    "birthdate": "2003-04-12",
    "address": "This is a kamal address",
    "registeredAt": "2023-04-01"
}
```

**Response**
```json
{
    "student": {
        "firstname": "Kamal",
        "lastname": "Ahmed",
        "birthdate": "2003-04-12",
        "address": "This is a kamal address",
        "id": 2,
        "registeredAt": "2023-04-01",
        "quizzes": null
    },
    "message": "student created"
}
```

#### Update student

```
  PUT /api/students
```

Note that all fields are **Required**

**Payload**
```json
{
    "id": 1,
    "firstname": "Rachid",
    "lastname": "Omar",
    "birthdate": "2003-04-12",
    "address": "This is a user address",
    "registeredAt": "2023-04-01"
}
```

**Response**
```json
{
    "student": {
        "firstname": "Rachid",
        "lastname": "Omar",
        "birthdate": "2003-04-12",
        "address": "This is a user address",
        "id": 1,
        "registeredAt": "2023-04-01",
        "quizzes": null
    },
    "message": "Student updated with success!"
}
```

#### Delete student

```
  DELETE /api/subjects/${id}
```
Note that the student id is **Required**

**Response**
```json
{
    "message": "Student deleted with success!"
}
```


#### Get all trainers

```
  GET /api/trainers
```

**Response**
```json
{
    "trainers": [
        {
            "firstname": "Mohammed",
            "lastname": "Amine",
            "birthdate": "2003-04-12",
            "address": "This is a mohammed address",
            "id": 1,
            "speciality": "speciality",
            "quizzes": []
        },
        {
            "firstname": "Marouane",
            "lastname": "El Amine",
            "birthdate": "2003-04-12",
            "address": "This is a marouane address",
            "id": 2,
            "speciality": "speciality",
            "quizzes": []
        }
    ],
    "message": "trainers found"
}
```

#### Get one trainer

```
  GET /api/trainers/${id}
```

Note that the trainer id is **Required**

**Response**
```json
{
    "student": {
        "firstname": "Mohammed",
        "lastname": "Amine",
        "birthdate": "2003-04-12",
        "address": "This is a mohammed address",
        "id": 1,
        "speciality": "speciality",
        "quizzes": []
    }
}
```

#### Create trainer

```
  POST /api/trainers
```
Note that all fields are **Required**

**Payload**
```json
{
    "firstname": "Marouane",
    "lastname": "El Amine",
    "birthdate": "2003-04-12",
    "address": "This is a marouane address",
    "speciality": "speciality"
}
```

**Response**
```json
{
    "trainer": {
        "firstname": "Marouane",
        "lastname": "El Amine",
        "birthdate": "2003-04-12",
        "address": "This is a marouane address",
        "id": 2,
        "speciality": "speciality",
        "quizzes": null
    },
    "message": "trainer created"
}
```

#### Update trainer

```
  PUT /api/trainers
```

Note that all fields are **Required**

**Payload**
```json
{
    "id": 1,
    "firstname": "Said",
    "lastname": "lahlali",
    "birthdate": "2003-04-12",
    "address": "This is a user address",
    "speciality": "speciality"
}
```

**Response**
```json
{
    "trainer": {
        "firstname": "Said",
        "lastname": "lahlali",
        "birthdate": "2003-04-12",
        "address": "This is a user address",
        "id": 1,
        "speciality": "speciality",
        "quizzes": null
    },
    "message": "Trainer updated with success!"
}
```

#### Delete trainer

```
  DELETE /api/trainers/${id}
```
Note that the trainer id is **Required**

**Response**
```json
{
    "message": "Trainer deleted with success!"
}
```



