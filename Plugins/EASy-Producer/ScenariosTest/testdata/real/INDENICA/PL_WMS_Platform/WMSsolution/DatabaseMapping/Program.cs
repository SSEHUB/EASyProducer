using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DatabaseMapping
{
    class Program
    {
        static void Main(string[] args)
        {

            wmstestdbEntities entities = new wmstestdbEntities();
            var query = from b in entities.Boxes select b;
            foreach (var b in query)
                Console.WriteLine(b.id + " " + b.name + " " + b.content);
            Console.ReadLine();
            
            //var c = from l in x. where l.box.Count() > 0 select new { LocationId = l.id, BoxCount = l.box.Count() };
        }
    }
}
