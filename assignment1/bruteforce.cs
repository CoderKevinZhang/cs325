using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Bruteforce
{
    class Program
    {
        static void Main(string[] args)
        {
            var list = new List<KeyValuePair<int, int>>();
            //list.Add(new KeyValuePair<string, int>(1, 1));

            if(args.Length < 1) {
                Console.Write("Usage: mono bruteforce.exe [example.input]\n");
                return;
            }

            string line = "";
            using(StreamReader sr = new StreamReader(args[0])) {
                while((line = sr.ReadLine()) != null) {
                    string[] tokens = line.Split();
                    int a = int.Parse(tokens[0]);
                    int b = int.Parse(tokens[1]);
                    list.Add(new KeyValuePair<int, int>(a, b));
                    Console.WriteLine(line);
                }
            }
        }
    }
}
