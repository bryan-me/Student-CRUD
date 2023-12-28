$(document).ready(function() {
    // Fetch persons on page load
    fetchPersons();

    // Get reference to the forms
    const createPersonForm = $('#create-person-form');
    const updatePersonForm = $('#update-person-form');
    const deletePersonForm = $('#delete-person-form');

    // Submit form to create a person
    createPersonForm.submit(function(event) {
        event.preventDefault();

        const name = $('#name').val();
        const age = $('#age').val();

        $.ajax({
            type: 'POST',
            url: '/persons',
            contentType: 'application/json',
            data: JSON.stringify({ name: name, age: age }),
            success: function(response) {
                fetchPersons(); // Refresh the list after creation
                createPersonForm[0].reset(); // Reset form fields
            },
            error: function(error) {
                console.error('Error creating person:', error);
            }
        });
    });

    // Submit form to update a person
    updatePersonForm.submit(function(event) {
        event.preventDefault();

        const id = $('#update-id').val();
        const name = $('#update-name').val();
        const age = $('#update-age').val();

        $.ajax({
            type: 'PUT',
            url: `/persons/${id}`,
            contentType: 'application/json',
            data: JSON.stringify({ name: name, age: age }),
            success: function(response) {
                fetchPersons(); // Refresh the list after update
                updatePersonForm[0].reset(); // Reset form fields
            },
            error: function(error) {
                console.error('Error updating person:', error);
            }
        });
    });

    // Submit form to delete a person
    deletePersonForm.submit(function(event) {
        event.preventDefault();

        const id = $('#delete-id').val();

        $.ajax({
            type: 'DELETE',
            url: `/persons/${id}`,
            success: function(response) {
                fetchPersons(); // Refresh the list after deletion
                deletePersonForm[0].reset(); // Reset form fields
            },
            error: function(error) {
                console.error('Error deleting person:', error);
            }
        });
    });

    function fetchPersons() {
        $.get('/persons', function(persons) {
            const personsList = $('#persons-list');
            personsList.empty();

            persons.forEach(function(person) {
                personsList.append(`<div>ID: ${person.id} | Name: ${person.name} | Age: ${person.age}</div>`);
            });
        });
    }
});
