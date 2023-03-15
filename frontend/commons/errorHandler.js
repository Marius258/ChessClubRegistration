export const errorHandler = (error) => {
  const errorContainer = document.querySelector('#errorContainer')
  errorContainer.classList = 'alert alert-warning alert-dismissible fade show'

  const strong = document.createElement('strong')
  strong.textContent = error.status
  errorContainer.appendChild(strong)

  const p = document.createElement('span')
  p.classList = 'ms-3'
  p.textContent = error.message
  errorContainer.appendChild(p)

  if (error.details) {
    for (let [key, value] of Object.entries(error.details)) {
      const validationError = document.createElement('span')
      validationError.classList = 'd-block'
      validationError.innerText = value
      errorContainer.appendChild(validationError)
    }
  }
}
