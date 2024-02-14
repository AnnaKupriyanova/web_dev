fun main() {
    val phone = MobilePhone("89236092710")
    phone.addContact(Contact("Sveta", "89234562134"))
    phone.addContact(Contact("Daria", "89231654782"))
    phone.addContact(Contact("Nik", "89231115687"))
    phone.printContacts()
    phone.updateContact(Contact("Sveta", "89234562134"), Contact("Svetlana", "89236912366"))
    phone.printContacts()
    phone.removeContact(Contact("Nik", "89231115687"))
    phone.printContacts()
    println("${phone.findContact(Contact("Daria", "89231654782"))}")
    println("${phone.queryContact("Daria")}")

    /*val tree = Node(2).apply {
        insert(5)
        insert(1)
        insert(3)
        println(this)
        delete(3)
    }*/

    val binaryTree = Node(5)
    binaryTree.insert(3)
    binaryTree.insert(7)
    binaryTree.insert(2)
    binaryTree.insert(4)
    binaryTree.insert(6)
    binaryTree.insert(8)
    println(binaryTree)
    binaryTree.delete(8)
}