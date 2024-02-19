fun main() {
    println("Mobile")
    val phone = MobilePhone("89236092710")
    phone.addContact(Contact("Sveta", "89234562134"))
    phone.addContact(Contact("Daria", "89231654782"))
    phone.addContact(Contact("Nik", "89231115687"))
    phone.printContacts()
    print("\n")
    phone.updateContact(Contact("Sveta", "89234562134"), Contact("Svetlana", "89236912366"))
    phone.removeContact(Contact("Nik", "89231115687"))
    phone.printContacts()
    println("index = ${phone.findContact(Contact("Daria", "89231654782"))}")
    println("${phone.queryContact("Daria")}")

<<<<<<< HEAD
    println("\nTree")
=======
>>>>>>> d1239d3dd476b905c7800041a774598a6cbd19f4
    val binaryTree = Node(5)
    binaryTree.insert(3)
    binaryTree.insert(7)
    binaryTree.insert(2)
    binaryTree.insert(4)
    binaryTree.insert(6)
    binaryTree.insert(8)
<<<<<<< HEAD
    print(binaryTree)
    binaryTree.delete(7)
    print("Tree without 7\n")
    print(binaryTree)
}
=======
    println(binaryTree)
    binaryTree.delete(8)
}
>>>>>>> d1239d3dd476b905c7800041a774598a6cbd19f4
