
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

```http
  GET /api/subjects/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. subject id |


#### Create subject

```http
  POST /api/subjects
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id`      | `string` | **Required**. subject id |
| `title` | `string` | **Required**. subject title |
| `parent` | `int` | parent id |

#### Update subject

```http
  PUT /api/subjects/${id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id`      | `string` | **Required**. subject id |
| `title` | `string` | **Required**. subject title |
| `parent` | `int` | parent id |

#### Delete subject

```http
  DELETE /api/subjects/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. subject id |

