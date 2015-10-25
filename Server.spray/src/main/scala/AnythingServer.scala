package anything.server



// ----------- Data Model


// ----------- 



trait FileCollection
{
    val name : String
}

trait FileType
{
    val name : String
    val fileExtensions : Set[ String ] // Without dot
    val ignoredTokens : Set[ String ]
}

trait File
{
}

case class TokenOccurrence( val file : File, val line : Int, val column : Int, val position : Int )

trait TokenCollection
{
    val name : String
    val tokenToOccurences : Map[ String, Seq[ TokenOccurrence ] ]
}

//have minimum length of 2 or 3 characters?
trait TokenIndex
{
    val prefixToTokens : Map[ String, Seq[ String ] ]
}
// use sorted list with alphabetical index list instead

trait TokenSpace
{
}

// - split into actors
// - actors operate on immutable tables
// - update 


// tasks:
// - turn search word into list of matching tokens
// - tokenize string ignoring all tokens from an ignore list
// - 


// Essentially aggregates several TokenCollections into one super collection
class AnythingServer
{
    def addTokenCollection( collection : TokenCollection ) {}
    //def removeTokenCollection( collection : TokenCollection ) {}

    def lookup( text : String ) : Iterator[ TokenOccurrence ] =
    {
        new TokenIterator
    }

    private class TokenIterator
        extends Iterator[ TokenOccurrence ]
    {
        def hasNext : Boolean = false
        def next() : TokenOccurrence = null
    }
}

