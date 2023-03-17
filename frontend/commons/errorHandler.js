export const errorHandler = async (error) => {
  const errorData = await error.json()
  const errorContainer = document.querySelector('#errorContainer')
  errorContainer.innerHTML = ''
  errorContainer.classList = 'alert alert-warning alert-dismissible fade show'

  const strong = document.createElement('strong')
  strong.textContent = errorData.status
  errorContainer.appendChild(strong)

  const p = document.createElement('span')
  p.classList = 'ms-3'
  p.textContent = errorData.message
  errorContainer.appendChild(p)

  if (errorData.details) {
    for (let [key, value] of Object.entries(errorData.details)) {
      const validationError = document.createElement('span')
      validationError.classList = 'd-block'
      validationError.innerText = value
      errorContainer.appendChild(validationError)
    }
  }
}
