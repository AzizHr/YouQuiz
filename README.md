
# YouQuiz

## API Documentaion

#### Get all subjects

```
  GET /api/subjects
```

**Result**
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

**Result**

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

**Result**
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

**Result**
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

**Result**

```
Subject with ID ${id} has been deleted.
```

