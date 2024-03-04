import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MobilePhoneTest {
    private val mobilePhone = MobilePhone("Anna", "89235897654")

    @Test
    fun addContact() {
        val contact = Contact("Sveta", "89235069212")
        assertTrue(mobilePhone.addContact(contact))
        assertFalse(mobilePhone.addContact(contact)) //exist
    }

    @Test
    fun updateContact() {
        val old = Contact("Sveta", "89235069212")
        val new = Contact("Sveta", "89235060000")
        mobilePhone.addContact(old)
        assertTrue(mobilePhone.updateContact(old, new))
        assertEquals(new, mobilePhone.queryContact("Sveta"))
    }

    @Test
    fun removeContact() {
        val contact = Contact("Sveta", "89235069212")
        mobilePhone.addContact(contact)
        assertTrue(mobilePhone.removeContact(contact))
        assertNull(mobilePhone.queryContact("Sveta"))
    }

    @Test
    fun findContact() {
        val contact = Contact("Sveta", "89235069212")
        mobilePhone.addContact(contact)
        assertEquals(0, mobilePhone.findContact(contact))
    }

    @Test
    fun queryContact() {
        val contact = Contact("Sveta", "89235069212")
        mobilePhone.addContact(contact)
        assertEquals(contact, mobilePhone.queryContact("Sveta"))
        assertNull(mobilePhone.queryContact("Seta"))
    }
}