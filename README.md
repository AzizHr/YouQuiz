
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

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id`      | `string` | subject id **(Required)** |
| `title` | `string` | subject title **(Required)** |
| `parent` | `int` | parent id |

#### Update subject

```
  PUT /api/subjects/${id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id`      | `string` | subject id **(Required)** |
| `title` | `string` | subject title **(Required)** |
| `parent` | `int` | parent id |

#### Delete subject

```
  DELETE /api/subjects/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | subject id **(Required)** |

