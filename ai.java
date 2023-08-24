let aiSnake = [];
aiSnake[0] = { x: 5 * box, y: 5 * box };

function aiMove(food, box) {
  let aiHeadX = aiSnake[0].x;
  let aiHeadY = aiSnake[0].y;

  const dX = food.x - aiHeadX;
  const dY = food.y - aiHeadY;

  if (Math.abs(dX) > Math.abs(dY)) {
    if (dX > 0) aiHeadX += box;
    else aiHeadX -= box;
  } else {
    if (dY > 0) aiHeadY += box;
    else aiHeadY -= box;
  }

  const newAiHead = {
    x: aiHeadX,
    y: aiHeadY
  };

  aiSnake.unshift(newAiHead);
  aiSnake.pop();
}

function drawAiSnake(context, box) {
  for (let i = 0; i < aiSnake.length; i++) {
    context.fillStyle = i === 0 ? 'blue' : 'lightblue';
    context.fillRect(aiSnake[i].x, aiSnake[i].y, box, box);

    context.strokeStyle = 'black';
    context.strokeRect(aiSnake[i].x, aiSnake[i].y, box, box);
  }
}

function checkAiCollisionWithFood(food, box) {
  if (aiSnake[0].x === food.x && aiSnake[0].y === food.y) {
    food = {
      x: Math.floor(Math.random() * 20) * box,
      y: Math.floor(Math.random() * 20) * box
    };
    aiSnake.push({ x: null, y: null }); 
  }
  return food;
}
