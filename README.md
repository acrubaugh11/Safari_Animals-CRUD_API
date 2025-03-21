# CRUD API for Safari Animals

##  Classes

### **Safari Animal**
- A JPA entity representing a safari animal in the database table named `animals`.  
- Includes fields: `animalId`, `name`, `description`, and `diet`.

### **Safari Animal Controller**
- REST controller providing API endpoints for managing safari animal objects.

### **Safari Animal Repository**
- Interface repository for managing safari animal entities.
- Extends JPA repository for CRUD operations.
- Includes two custom queries using native SQL:
  - Retrieving animals by a given string.
  - Retrieving animals filtered by diet.

### **Safari Animals Service**
- Acts as a go-between for the controller and repository class.
- Handles all business logic for safari animals and backend operations.

---

# Endpoints:

### **Get a list of all safari animals in database:**
  http://localhost:8080/animals/all

  Returns - A Json array of safari animal objects
  ```json
[ 
  {
    "animalId": 1,
    "name": "giraffe",
    "description": "large African hoofed mammal belonging to the genus Giraffa",
    "diet": "herbivore"
  },
  {
    "animalId": 2,
    "name": "elephant",
    "description": "large, intelligent herbivore mammal known for its trunk, tusks, and size",
    "diet": "herbivore"
  },
  {
    "animalId": 3,
    "name": "cheetah",
    "description": "slender, fast-running big cat known for its spotted coat and incredible speed",
    "diet": "carnivore"
  },
  {
    "animalId": 4,
    "name": "rhino",
    "description": "thick-skinned herbivore known for its horn and armored appearance",
    "diet": "herbivore"
  },
  {
    "animalId": 5,
    "name": "zebra",
    "description": "striped, hoofed mammal known for its unique black-and-white pattern",
    "diet": "herbivore"
  },
  {
    "animalId": 6,
    "name": "lion",
    "description": "powerful, social big cat known as the \"king of the jungle\"",
    "diet": "carnivore"
  }
] 
```

### **Get safari animal by ID:**
  http://localhost:8080/animals/2

  Returns - A Json safari animal object
  ```json
{
	"animalId": 1,
	"name": "giraffe",
	"description": "large African hoofed mammal belonging to the genus Giraffa",
	"diet": "herbivore"
}

```

### **Fetch all safari animals whose diet meets the restriction:**
  http://localhost:8080/animals/diet/carnivore

  Returns - A Json array of safari animal objects with specified diet restriciton
  ```json
[
	{
		"animalId": 3,
		"name": "cheetah",
		"description": "slender, fast-running big cat known for its spotted coat and incredible speed",
		"diet": "carnivore"
	},
	{
		"animalId": 6,
		"name": "lion",
		"description": "powerful, social big cat known as the \"king of the jungle\"",
		"diet": "carnivore"
	}
]
```

### **Fetch safari animals by string:**
  http://localhost:8080/animals/name?search=zebra

  Returns - A Json array of safari animal objects that contain specified string in their name
  ```json
[
	{
		"animalId": 5,
		"name": "zebra",
		"description": "striped, hoofed mammal known for its unique black-and-white pattern ",
		"diet": "herbivore"
	}
]
```
  

### **Create a new safari animal entry:**
  http://localhost:8080/animals/new  --data '{  "name": "sample new safari animal", "description": "large mammal", "diet": carnivore}'

  Returns - A Json array of all safari animal objects with new safari animal entry

### **Update an existing safari animal object:**
  http://localhost:8080/animals/update/2 --data '{  "name": "sample new safari animal", "description": "large mammal", "diet": carnivore}'

  Returns - A Json object of the updated safari animal

### **Delete a safari animal object:**
  http://localhost:8080/animals/delete/1

  Returns - A Json array of all safari animal objects after deleting specified safari animal object







  
