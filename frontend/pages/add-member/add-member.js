import { saveMember } from '../../commons/requests.js'

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
    const requestSuccessful = await saveMember(member)
    if (requestSuccessful) {
      window.location.replace('../members-list/members-list.html')
    }
  })
}

;(async () => {
  await handleFormSubmit()
})()
