
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

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | subject id **(Required)** |


#### Create subject

```
  POST /api/subjects
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

