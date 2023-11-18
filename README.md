
# YouQuiz

## API Documentaion

#### Get all subjects

```
  GET /api/subjects
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `int` | subject id |
| `title` | `string` | subject title |
| `parent` | `Subject` | subject parent |
| `children` | `Subject[]` | subject children |

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

