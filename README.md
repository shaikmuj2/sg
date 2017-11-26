
Assumpition

- Initial Brand & Category informaiton exists preloaded
- Not ThreadSafe, Assumption is single threded.
- Asumming input file is provided as expected and no errors . Error handling and input file validation have not been done.

Please note the system is built to accomodate the current requirement at a broader design perspective which can be extended or consumed in a better way if it needs to be integrated to external system.
Considering the timeframe, i have kept the system simple , Exception handling, logging,  Multithreading, Any floating computation are kept out of scope

Design of discount computation

Start With entities
- Brand : Definition of Brand , currently holds basic brand name and Discount Entity
- Category : Category information, Parent defines the parent category.
- Item : defines the basic form of object which is a physical thing and can be sold
- Discount : Generic discount , can be linked with any type of entites. exampe 20% discount object can be linked to Category or Item or any other object


Class Design

DiscountClient -> DiscountHelper 
               ->HierarchyDiscountStratgey
Discount Client - For System to work this class works as a component to parse files and compute discount. Point where users can consume the services of discount system (In a bigger picture, this would idelly be handled by exposing services to compute dicount and to build entities)

Discount Helper - Provides few methods to parse the input data form file. Parsing is kept simple, Newline are assumed to be trimmed and File  is expected to be as defined without any error.

HierarchyDiscountStratgey - Used Strategy pattern with an interface which provides the contract for computation. This Strategy class provides the docunted value based on Hierarchy of category and the max of category Brand and item discount .


Caching - 

BrandCache - Caching mechanism for storing brand details which could be fetched based on brand name. This is used to build the ItemInfo while we parse the input file data

CategoryCache - Caching mechanism for Storing category details . Again helping in provding the details while buildng the Iteminfo.

Please not Cache is built in the code by me with static data , in real scenarios this cache would be assumed to be built and constantly refreshed.

Cache Implementation in rela scenarios are static ways, have kept it simple my code and instatiated it once.
