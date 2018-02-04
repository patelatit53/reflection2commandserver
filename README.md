# reflection2commandserver
The Command pattern is known as a behavioural pattern,as it's used to manage algorithms, relationships and responsibilities between objects. 
The Command Pattern
The Command pattern is known as a behavioural pattern,as it's used to manage algorithms, relationships and responsibilities between objects. Thedefinition of Command provided in the original Gang of Four book on DesignPatterns states: 

Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations

So what does this mean in a class diagram? 

Image title



Command declares an interface for all commands, providing a simple execute() method which asks the Receiver of the command to carry out an operation. The Receiver has the knowledge of what to do to carry out the request.  The Invoker holds a command and can get the Command to execute a request by calling the execute method. The Client creates ConcreteCommands and sets a Receiver for the command. The ConcreteCommand defines a binding between the action and the receiver. When the Invoker calls execute the ConcreteCommand will run one or more actions on the Receiver.

The following sequence diagram shows the relationship in a clearer way: 

Image title

If this all seems a bit confusing right now, hang on for the code example later on in the article.

When Would I Use This Pattern?
The Command Pattern is useful when:

A history of requests is needed
You need callback functionality
Requests need to be handled at variant times or in variant orders
The invoker should be decoupled from the object handling the invocation.
You'll see command being used a lot when you need to have multiple undo operations, where a stack of the recently executed commands are maintained. To implement the undo, all you need to do is get the last Command in the stack and execute it's undo() method.

You'll also find Command useful for wizards, progress bars, GUI buttons and menu actions, and other transactional behaviour. 

So How Does It Work In Java?
Let's use a remote control as the example. Our remote is the center of home automation and can control everything. We'll just use a light as an example, that we can switch on or off, but we could add many more commands.
