const apiKey = 'your-api-key-here'; // Replace with your actual OpenWeatherMap API key

function getWeather() {
  const city = document.getElementById('city').value;
  
  if (city === '') {
    alert('Please enter a city name');
    return;
  }

  const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`;

  fetch(url)
    .then(response => response.json())
    .then(data => {
      if (data.cod === '404') {
        alert('City not found');
      } else {
        displayWeather(data);
      }
    })
    .catch(error => {
      console.error('Error fetching weather data:', error);
      alert('Error fetching weather data');
    });
}

function displayWeather(data) {
  document.getElementById('city-name').textContent = data.name + ', ' + data.sys.country;
  document.getElementById('temperature').textContent = `Temperature: ${data.main.temp} °C`;
  document.getElementById('description').textContent = `Weather: ${data.weather[0].description}`;
  document.getElementById('humidity').textContent = `Humidity: ${data.main.humidity}%`;
  document.getElementById('wind').textContent = `Wind Speed: ${data.wind.speed} m/s`;
}
