import { saveMember } from '../../commons/requests.js'
import { errorHandler } from '../../commons/errorHandler.js'

const handleFormSubmit = async () => {
  const addMemberForm = document.querySelector('#addMemberForm')
  addMemberForm.addEventListener('submit', async (e) => {
    e.preventDefault()
    const member = {
      pin: addMemberForm.personalIdentificationNumber.value,
      name: addMemberForm.name.value,
      lastname: addMemberForm.lastname.value,
      email: addMemberForm.email.value,
      startedPlaying: addMemberForm.startedPlaying.value,
    }
    const savedMember = await saveMember(member)
    if (savedMember.message) {
      errorHandler(savedMember)
    }
  })
}

;(async () => {
  await handleFormSubmit()
})()
