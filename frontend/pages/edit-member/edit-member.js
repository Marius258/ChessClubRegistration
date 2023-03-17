import { getMemberById, patchMember } from '../../commons/requests.js'

const editMemberForm = document.querySelector('#editMemberForm')

let oldMemberData

const loadMemberData = async () => {
  const urlParams = new URLSearchParams(window.location.search)
  const memberId = urlParams.get('id')

  oldMemberData = await getMemberById(memberId)
  oldMemberData.timeSinceStartedPlaying = getTimeSinceStartedPlayingDate(
    oldMemberData.timeSinceStartedPlaying
  )
  editMemberForm.name.value = oldMemberData.name
  editMemberForm.lastname.value = oldMemberData.lastname
  editMemberForm.email.value = oldMemberData.email
  editMemberForm.startedPlaying.value = oldMemberData.timeSinceStartedPlaying
}

// Example "10 years 5 months 3 days" turns into 2012-10-13
const getTimeSinceStartedPlayingDate = (timeSinceStartedPlaying) => {
  if (!timeSinceStartedPlaying) {
    return null
  }
  const timeComponents = timeSinceStartedPlaying.split(' ')
  const today = new Date()
  const startDate = new Date(
    today.getFullYear() - parseInt(timeComponents[0]),
    today.getMonth() - parseInt(timeComponents[2]),
    today.getDate() - parseInt(timeComponents[4]) + 1
  )

  return startDate.toISOString().substring(0, 10)
}

const handleFormSubmit = async () => {
  editMemberForm.addEventListener('submit', async (e) => {
    e.preventDefault()

    const member = {
      name:
        oldMemberData.name !== editMemberForm.name.value
          ? editMemberForm.name.value
          : oldMemberData.name,
      lastname:
        oldMemberData.lastname !== editMemberForm.lastname.value
          ? editMemberForm.lastname.value
          : oldMemberData.lastname,
      email:
        oldMemberData.email !== editMemberForm.email.value
          ? editMemberForm.email.value
          : oldMemberData.email,
      startedPlaying:
        oldMemberData.timeSinceStartedPlaying !==
        editMemberForm.startedPlaying.value
          ? editMemberForm.startedPlaying.value
          : oldMemberData.timeSinceStartedPlaying,
    }

    const requestSuccessful = await patchMember(member, oldMemberData.id)
    if (requestSuccessful) {
      window.location.replace('../members-list/members-list.html')
    }
  })
}

;(async () => {
  await loadMemberData()
  await handleFormSubmit()
})()
