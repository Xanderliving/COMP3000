const express = require('express');
const bodyParser = require('body-parser');
const { MongoClient } = require('mongodb');

const app = express();
const port = 3001;

const mongoUrl = 'mongodb+srv://Mixologist:Mixologist@cocktails.ymnk2j8.mongodb.net/?retryWrites=true&w=majority&appName=Cocktails';
const dbName = 'CocktailList';

app.use(bodyParser.json());

const startServer = async () => {
  try {
    const client = await MongoClient.connect(mongoUrl);
    console.log('Connected to MongoDB');
    const db = client.db(dbName);

    app.get('/api/data', async (req, res) => {
      try {
        const result = await db.collection('Cocktails').find({}).toArray();
        res.json(result);
      } catch (err) {
        console.error('Error fetching data:', err);
        res.status(500).send('Internal Server Error');
      }
    });


let items = [
  { id: 1, name: "Vodka", status: "Off" },
  { id: 2, name: "Gin", status: "Off" },
  { id: 3, name: "Rum", status: "Off" },
  { id: 4, name: "Tequila", status: "Off" },
  { id: 5, name: "Coke", status: "Off" },
  { id: 6, name: "Lemonade", status: "Off" }
];
app.use(bodyParser.json());


app.get('/pumps', (req, res) => {
  res.json(items);
});

app.get('/pumps/:id', (req, res) => {
  const itemId = parseInt(req.params.id);
  
  // Find the item by ID
  const foundItem = items.find(item => item.id === itemId);
  if (!foundItem) {
    return res.status(404).send('Item not found');
  }

  res.json(foundItem);
});

// PUT to update item status by ID
app.put('/pumps/:id', (req, res) => {
  const itemId = parseInt(req.params.id);
  const newStatus = req.body.status;

  // Find the item by ID
  const itemIndex = items.findIndex(item => item.id === itemId);
  if (itemIndex === -1) {
    return res.status(404).send('Item not found');
  }

  // Update the item status
  items[itemIndex].status = newStatus;
  res.json(items[itemIndex]);
});
    // Add more routes for other CRUD operations

    app.listen(port, () => {
      console.log(`Server running at http://localhost:${port}`);
    });
  } catch (err) {
    console.error('Error connecting to MongoDB:', err);
  }
};


startServer();

